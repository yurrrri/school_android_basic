package ddwucom.mobile.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnDisplay;
    TextView tvDisplay;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnDisplay = findViewById(R.id.btnDisplay);
        tvDisplay = findViewById(R.id.tvDisplay);

        //1번
//        Display disPlay = new Display();
//        btnDisplay.setOnClickListener(disPlay);

        //2번
//        btnDisplay.setOnClickListener(myClickListener);

        //3번
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = editText.getText().toString();
                tvDisplay.setText(text);
            }
        });
    }

//    class Display implements View.OnClickListener{
//        @Override
//        public void onClick(View v) {
//            text = editText.getText().toString();
//            tvDisplay.setText(text);
//        }
//    }
//
//    View.OnClickListener myClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            text = editText.getText().toString();
//            tvDisplay.setText(text);
//        }
//    };
}
