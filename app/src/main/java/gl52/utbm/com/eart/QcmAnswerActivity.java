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

        Intent intent = getIntent();
        String userAnswer = intent.getStringExtra(EXTRA_USER_ANSWER);
        String goodAnswer = intent.getStringExtra(EXTRA_ANSWER);

        if(userAnswer.toLowerCase().equals(goodAnswer.toLowerCase())){
            resultat = "Good answer !";
        }

        TextView resultView = (TextView) findViewById(R.id.textResultQuestion);
        if(resultView != null){
            resultView.setText(resultat);
        }

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
