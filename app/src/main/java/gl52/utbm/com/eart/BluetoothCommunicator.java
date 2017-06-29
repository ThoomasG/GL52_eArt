package gl52.utbm.com.eart;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Thomas on 22/06/2017.
 */


// send message :                 (new Thread(new workerThread("temp"))).start();


public class BluetoothCommunicator implements Runnable{

    BluetoothSocket mmSocket;
    BluetoothDevice mmDevice = null;

    private String btMsg;
    private String data;

    final Handler handler = new Handler();
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


    final byte delimiter = 33;
    int readBufferPosition = 0;


    public void sendBtMsg(String msg2send){
        //UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard SerialPortService ID
        UUID uuid = UUID.fromString("94f39d29-7d6d-437d-973b-fba39e49d4ee"); //Standard SerialPortService ID
        try {

            mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
            if (!mmSocket.isConnected()){
                mmSocket.connect();
            }

            String msg = msg2send;
            //msg += "\n";
            OutputStream mmOutputStream = mmSocket.getOutputStream();
            mmOutputStream.write(msg.getBytes());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public BluetoothCommunicator(String message){

        btMsg = message;
    }

    @Override
    public void run() {

        sendBtMsg(btMsg);
        while(!Thread.currentThread().isInterrupted())
        {
            int bytesAvailable;
            boolean workDone = false;

            try {



                final InputStream mmInputStream;
                mmInputStream = mmSocket.getInputStream();
                bytesAvailable = mmInputStream.available();
                if(bytesAvailable > 0)
                {

                    byte[] packetBytes = new byte[bytesAvailable];
                    Log.e("Aquarium recv bt","bytes available");
                    byte[] readBuffer = new byte[1024];
                    mmInputStream.read(packetBytes);

                    for(int i=0;i<bytesAvailable;i++)
                    {
                        byte b = packetBytes[i];
                        if(b == delimiter)
                        {
                            byte[] encodedBytes = new byte[readBufferPosition];
                            System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.length);
                            data = new String(encodedBytes, "US-ASCII");
                            readBufferPosition = 0;

                            //The variable data now contains our full command
                            handler.post(new Runnable()
                            {
                                public void run()
                                {   Log.e("BLUETOOTHMESSAGE", data);
                                }
                            });

                            workDone = true;
                            break;


                        }
                        else
                        {
                            readBuffer[readBufferPosition++] = b;
                        }
                    }

                    if (workDone == true){
                        mmSocket.close();
                        break;
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    public String getData(){
        return data;
    }

}




