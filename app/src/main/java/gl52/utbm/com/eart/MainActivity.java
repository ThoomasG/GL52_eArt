package gl52.utbm.com.eart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTakePicture = (Button) findViewById(R.id.pictureButton);
        buttonTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TakePictureActivity.class);
                startActivity(intent);
            }
        });

        Button buttonArtInfo = (Button) findViewById(R.id.artInfoButton);
        buttonArtInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArtInfoActivity.class);
                startActivity(intent);
            }
        });

        Button buttonTrainInfo = (Button) findViewById(R.id.trainInfoButton);
        buttonTrainInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TrainInfoActivity.class);
                startActivity(intent);
            }
        });

        Button buttonChargePhone = (Button) findViewById(R.id.chargeButton);
        buttonChargePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ChargePhoneActivity.class);
                intent.putExtra("answer", 0);
                startActivity(intent);
            }
        });

        Button buttonBluetooth = (Button) findViewById(R.id.bluetoothButton);
        buttonBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BluetoothActivity.class);
                startActivity(intent);
            }
        });

        Button buttonTestBluetooth = (Button) findViewById(R.id.bluetoothTestButton);
        buttonTestBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BluetoothTestActivity.class);
                startActivity(intent);
            }
        });
    }
}
