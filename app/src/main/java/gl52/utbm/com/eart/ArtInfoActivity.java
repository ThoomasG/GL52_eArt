package gl52.utbm.com.eart;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import gl52.utbm.com.eart.Util.ArtInformation;
import gl52.utbm.com.eart.Util.SncfApiConnectivity;

/**
 * Created by Thomas on 07/06/2017.
 */

public class ArtInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_information);

        /*

        String request = "REQUEST/ART";

        BluetoothCommunicator bc = new BluetoothCommunicator(request);
        new Thread(bc).start();

        String nameP;

        if(bc.getData() != null){
            nameP = bc.getData().split("/")[1];
            int resourceId = this.getResources().getIdentifier(nameP, "drawable", this.getPackageName());
        }

        */


        String strDescription = ArtInformation.descriptions[1][1];

        TextView description = (TextView)findViewById(R.id.artDescription);
        description.setText(strDescription);

        ImageView painting = (ImageView)findViewById(R.id.artImage);
        painting.setImageResource(R.drawable.joconde);


    }
}
