package ddwucom.mobile.activitiy_test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    final static int SUB_ACTIVITY_CODE = 100;
    final static String TAG = "subActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
//                Intent intent = new Intent(MainActivity.this, SubActivity1.class);
                //묵시적(implicit) 인텐트
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
//                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:012-3456-7890"));
                Intent intent = new Intent(MainActivity.this, SubActivity2.class);
//                String id="cooling";
//                ArrayList<String> foods = new ArrayList<String>();
////              *List는 Serializable 구현 X
//                foods.add("사과");
//                foods.add("배");
//                foods.add("오렌지");
//
//                intent.putExtra("id", id);
//                intent.putExtra("foods", foods);
//                startActivity(intent);
                startActivityForResult(intent, SUB_ACTIVITY_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case SUB_ACTIVITY_CODE:
                if (resultCode==RESULT_OK){
                    String result = data.getStringExtra("result_data");
                    Toast.makeText(this, "Result "+result, Toast.LENGTH_SHORT).show();
                }
                else
                    Log.d(TAG, "canceled");
                break;
        }
    }
}
