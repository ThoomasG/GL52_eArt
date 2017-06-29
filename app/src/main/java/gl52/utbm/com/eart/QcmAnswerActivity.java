package gl52.utbm.com.eart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

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

        final TextView timerView = (TextView)findViewById(R.id.countView);

        new CountDownTimer(180000, 1000) {

            public void onTick(long millisUntilFinished) {

                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished-(minutes*60*1000));

                timerView.setText(minutes + ":" + seconds);
            }

            public void onFinish() {
                timerView.setText("NO MORE POWER");
            }

        }.start();

        final ImageView image = (ImageView)findViewById(R.id.batteryView);

        final Button back = (Button) findViewById(R.id.btnBackMenu);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QcmAnswerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
