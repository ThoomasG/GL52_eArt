package gl52.utbm.com.eart;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Thomas on 07/06/2017.
 */

public class ChargePhoneActivity extends Activity {

    final String VILLE = "ville";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_phone);

        final Button answer1 = (Button) findViewById(R.id.answerButton1);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChargePhoneActivity.this, QcmAnswerActivity.class);
                intent.putExtra(VILLE, answer1.getText().toString());
                startActivity(intent);
            }
        });

        final Button answer2 = (Button) findViewById(R.id.answerButton2);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChargePhoneActivity.this, QcmAnswerActivity.class);
                intent.putExtra(VILLE, answer2.getText().toString());
                startActivity(intent);
            }
        });


        final Button answer3 = (Button) findViewById(R.id.answerButton3);
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChargePhoneActivity.this, QcmAnswerActivity.class);
                intent.putExtra(VILLE, answer3.getText().toString());
                startActivity(intent);
            }
        });
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
