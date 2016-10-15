package id.sch.smktelkom_mlg.learn.fishingclubregistration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    RadioButton rbB, rbA, rbP;
    EditText etName;
    TextView tvHasilName, tvHasilExp, tvHasilRod
    CheckBox cbS, cbI, cbF;
    Button bOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbB = (RadioButton) findViewById(R.id.rbB);
        rbA = (RadioButton) findViewById(R.id.rbA);
        rbP = (RadioButton) findViewById(R.id.rbP);
        cbS = (CheckBox) findViewById(R.id.cbS);
        cbI = (CheckBox) findViewById(R.id.cbI);
        cbF = (CheckBox) findViewById(R.id.cbF);
        etName = (EditText) findViewById(R.id.etName);
        tvHasilName = (TextView) findViewById(R.id.tvHasilName);
        tvHasilExp = (TextView) findViewById(R.id.tvHasilExp);
        tvHasilRod = (TextView) findViewById(R.id.tvHasilRod);
        bOk = (Button) findViewById(R.id.bOk);


        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doName();
                doExp();
                doRod();
            }

        });

    }

    private void doRod() {
        if (isValid()) {
            String name = etName.getText().toString();
            tvHasilName.setText("Your name is " + name);
        }
    }

    private void doExp() {
        String hasil = null;

        if (rbB.isChecked()) {
            hasil = rbB.getText().toString();
        } else if (rbA.isChecked()) {
            hasil = rbA.getText().toString();
        } else if (rbP.isChecked()) {
            hasil = rbP.getText().toString();
        }

        if (hasil == null) {
            tvHasilExp.setText("You doesn't choose any option ");
        } else {
            tvHasilExp.setText("Your Experience is " + hasil);
        }
    }

    private void doName() {
        if (isValid()) {
            String name = etName.getText().toString();
            tvHasilName.setText("Your name is " + name);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String name = etName.getText().toString();

        if (name.isEmpty()) {
            etName.setError("Name field must be filled");
            valid = false;
        } else if (name.length() < 3) {
            etName.setError("Name unacceptable");
            valid = false;
        } else {
            etName.setError(null);
        }

        return valid;
    }
}
