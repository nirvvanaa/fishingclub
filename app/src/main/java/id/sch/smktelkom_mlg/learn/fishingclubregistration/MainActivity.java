package id.sch.smktelkom_mlg.learn.fishingclubregistration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText etName;
    TextView tvHasilName;
    Button bOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        tvHasilName = (TextView) findViewById(R.id.tvHasilName);
        bOk = (Button) findViewById(R.id.bOk);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }

        });

    }

    private void doProcess() {
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
