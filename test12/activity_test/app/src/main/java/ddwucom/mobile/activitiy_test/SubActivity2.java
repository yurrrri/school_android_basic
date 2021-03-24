package ddwucom.mobile.activitiy_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnOk:
                Intent resultIntent = new Intent(); //결과값을 저장할 intent
                resultIntent.putExtra("result_data", "SubActivity returns data");
                setResult(RESULT_OK, resultIntent);
                break;
            case R.id.btnCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        //액티비티 종료
        finish();
    }
}