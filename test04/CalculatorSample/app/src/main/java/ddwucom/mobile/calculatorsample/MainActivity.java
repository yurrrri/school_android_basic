package ddwucom.mobile.calculatorsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String result;
    EditText etDisplay;
    int num1, num2, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDisplay = findViewById(R.id.etDisplay);
    }

    public void onClick(View v){
        result = etDisplay.getText().toString();

        switch (v.getId()){
            case R.id.btn_1:
                result += "1";
                etDisplay.setText(result);
                break;
            case R.id.btn_2:
                result+="2";
                etDisplay.setText(result);
                break;
            case R.id.btn_plus:
                num1 = Integer.parseInt(result);
                etDisplay.setText("");
                break;
            case R.id.btn_equal:
                num2 = Integer.parseInt(result);
                sum = num1+num2;
                etDisplay.setText(Integer.toString(sum));
                break;
        }
    }
}