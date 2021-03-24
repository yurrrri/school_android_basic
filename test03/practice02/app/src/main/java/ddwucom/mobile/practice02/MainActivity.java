package ddwucom.mobile.practice02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onMyBtnClick(View v) {

        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etPhone = (EditText) findViewById(R.id.etPhone);

        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();

        Toast.makeText(this, "안녕하세요. 저는 "+name+" 입니다. 전화번호는 "+phone+" 입니다.", Toast.LENGTH_SHORT).show();
    }

    public void onMyExitBtnClick(View v){
        finish();
    }
}
