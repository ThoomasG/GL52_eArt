package gl52.utbm.com.eart;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Thomas on 07/06/2017.
 */

public class TakePictureActivity extends Activity {

    Button cameraButton;
    int CAMERA_PIC_REQUEST = 2;
    int  TAKE_PICTURE=0;
    Camera camera;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);

        cameraButton =(Button) findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });
    }

}
