package ddwucom.mobile.test14.exam02;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    Food food;
    EditText etFood;
    EditText etNation;

    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        //반환되는 형태가 Serializable객체이기 때문에, Typecasting을 해주어야함
        food = (Food) getIntent().getSerializableExtra("food");

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);

        foodDBManager = new FoodDBManager(this);

        etFood.setText(food.getFood());
        etNation.setText(food.getNation());
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
                String foodName = etFood.getText().toString();
                String nation = etNation.getText().toString();

                food.setFood(foodName);
                food.setNation(nation);

                boolean result = foodDBManager.modifyFood(food);

                if (result){
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("food", foodName);
                    setResult(RESULT_OK, resultIntent);
                }
                else{
                    setResult(RESULT_CANCELED);
                }

                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
