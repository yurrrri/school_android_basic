package ddwucom.mobile.activitiy_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SubActivity1 extends AppCompatActivity {

    final static String TAG = "subActivity1";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        Intent intent = getIntent(); //실행 시 전달 받은 Intent 확보

        String id = intent.getStringExtra("id");
        ArrayList<String> foods = (ArrayList) intent.getSerializableExtra("foods");

        Log.d(TAG, "id : "+id);
        Log.d(TAG, "food1 : "+foods.get(0));
        Log.d(TAG, "food2 : "+foods.get(1));
        Log.d(TAG, "food3 : "+foods.get(2));
    }
}