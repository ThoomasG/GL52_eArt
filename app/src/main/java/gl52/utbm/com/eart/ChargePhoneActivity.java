package gl52.utbm.com.eart;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import gl52.utbm.com.eart.Util.QuizzQuestions;

/**
 * Created by Thomas on 07/06/2017.
 */

public class ChargePhoneActivity extends Activity {

    final String EXTRA_ANSWER= "answer";
    final String EXTRA_USER_ANSWER = "userAnswer";

    int nbCorrectAnswer = 0;

    int numQuestion = (int)(Math.random()*7);
    String [] actualQuestion = QuizzQuestions.questions[numQuestion];
    String correctAnswer = actualQuestion[4];

    static TextView quest = null;
    static Button answer1 = null;
    static Button answer2 = null;
    static Button answer3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_phone);

        quest = (TextView) findViewById(R.id.textQuestion);
        quest.setText(actualQuestion[0]);

        final Button answer1 = (Button) findViewById(R.id.answerButton1);
        answer1.setText(actualQuestion[1]);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer.toLowerCase().equals(answer1.getText().toString().toLowerCase())) {
                    majQuestion(true);
                }else{
                    majQuestion(false);
                }
            }
        });

        answer2 = (Button) findViewById(R.id.answerButton2);
        answer2.setText(actualQuestion[2]);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer.toLowerCase().equals(answer2.getText().toString().toLowerCase())) {
                    majQuestion(true);
                }else{
                    majQuestion(false);
                }
            }
        });


        answer3 = (Button) findViewById(R.id.answerButton3);
        answer3.setText(actualQuestion[3]);
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer.toLowerCase().equals(answer3.getText().toString().toLowerCase())) {
                    majQuestion(true);
                }else{
                    majQuestion(false);
                }
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

    private void majQuestion(boolean good){
        if(good){
            nbCorrectAnswer++;
        }
        if(nbCorrectAnswer >= 3){
            nbCorrectAnswer = 0;
            Intent intent = new Intent(ChargePhoneActivity.this, QcmAnswerActivity.class);
            startActivity(intent);
        }else{
            numQuestion = (int)(Math.random()*7);
            actualQuestion = QuizzQuestions.questions[numQuestion];
            correctAnswer = actualQuestion[4];

            quest = (TextView) findViewById(R.id.textQuestion);
            answer1 = (Button) findViewById(R.id.answerButton1);
            answer2 = (Button) findViewById(R.id.answerButton2);
            answer3 = (Button) findViewById(R.id.answerButton3);

            quest.setText(actualQuestion[0]);
            answer1.setText(actualQuestion[1]);
            answer2.setText(actualQuestion[2]);
            answer3.setText(actualQuestion[3]);

        }
    }

}
