package gl52.utbm.com.eart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Thomas on 11/06/2017.
 */

public class QcmAnswerActivity extends Activity {

    final String EXTRA_ANSWER= "answer";
    final String EXTRA_USER_ANSWER = "userAnswer";
    String resultat = "Wrong answer !";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm_answer);


        final Button back = (Button) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QcmAnswerActivity.this, ChargePhoneActivity.class);
                startActivity(intent);
            }
        });


    }
}
