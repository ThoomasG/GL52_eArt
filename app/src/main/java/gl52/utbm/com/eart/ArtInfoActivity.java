package gl52.utbm.com.eart;

import android.app.Activity;
import android.os.Bundle;

import gl52.utbm.com.eart.Util.SncfApiConnectivity;

/**
 * Created by Thomas on 07/06/2017.
 */

public class ArtInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_information);
        try {
            SncfApiConnectivity sncfApi = new SncfApiConnectivity();
            sncfApi.getIdFromResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
