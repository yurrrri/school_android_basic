package ddwucom.mobile.test03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //MainActivity 실행시 onCreate 메소드 실행
        super.onCreate(savedInstanceState);

        TextView myText = new TextView(this);
        String text = "Android Programming!";
        Log.d(TAG, text);

        text = "mobile";
        Log.d(TAG, text);

        myText.setText(text);
        setContentView(myText);
        //setContentView(R.layout.activity_main);
    }
}
