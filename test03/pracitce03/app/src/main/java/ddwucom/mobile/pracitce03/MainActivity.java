package ddwucom.mobile.pracitce03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v){
        EditText editText = (EditText) findViewById(R.id.editText);

        switch(v.getId()){
            case R.id.btnOne:
                name += "1";
                break;

            case R.id.btnTwo:
                name+= "2";
                break;

            case R.id.btnThree:
                name+= "3";
                break;

            case R.id.btnClear:
                name ="";
                break;
        }

        editText.setText(name);

    }
}
