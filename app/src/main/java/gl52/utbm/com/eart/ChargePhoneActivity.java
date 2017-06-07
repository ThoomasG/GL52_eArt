package gl52.utbm.com.eart;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Thomas on 07/06/2017.
 */

public class ChargePhoneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_phone);



    }

    @Override
    protected void onStart()
    {
        super.onStart();

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.qcm_popup);
        dialog.setTitle("QCM Information");

        Button button = (Button) dialog.findViewById(R.id.button_qcm_validate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
