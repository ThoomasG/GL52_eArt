package gl52.utbm.com.eart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Thomas on 11/06/2017.
 */

public class QcmAnswerActivity extends Activity {

    final String VILLE = "ville";
    String resultat = "Wrong answer !";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm_answer);

        Intent intent = getIntent();
        String selectedCity = intent.getStringExtra(VILLE);

        if(selectedCity.toLowerCase().equals("paris")){
            resultat = "Good answer !";
        }

        TextView resultView = (TextView) findViewById(R.id.textResultQuestion);
        if(resultView != null){
            resultView.setText(resultat);
        }


    }
}
