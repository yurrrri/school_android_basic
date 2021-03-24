package ddwucom.mobile.test12.exam02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int REQ_CODE = 100;

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList;

    FoodManager foodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodManager = new FoodManager();
        foodList = foodManager.getFoodList();

        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);

        listView.setAdapter(adapter);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, SubActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        새로운 food 추가 시 foodManager의 addFood() 메소드를 사용할 것
        switch(requestCode){
            case REQ_CODE:
                if (resultCode==RESULT_OK) {
                    //직렬화해야하는 객체를 받으면, typecasting을 해야함
                    Food food = (Food) data.getSerializableExtra("add_food");
                    foodManager.addFood(food);
                    adapter.notifyDataSetChanged();
                    break;
                }
        }
    }



}
