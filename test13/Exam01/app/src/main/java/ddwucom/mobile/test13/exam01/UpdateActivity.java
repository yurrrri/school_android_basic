package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    FoodDBHelper myDbHelper;
    EditText etUpdateId;
    EditText etUpdateFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        myDbHelper = new FoodDBHelper(this);
        etUpdateId = findViewById(R.id.etUpdateId);
        etUpdateFood = findViewById(R.id.etUpdateFood);
    }

    public void onClick(View v){

        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();

        switch (v.getId()){
            case R.id.btnUpdateFood:
                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, etUpdateFood.getText().toString());

                String whereClause = "_id=?";
                String[] whereArgs =new String[]{etUpdateId.getText().toString()};

                myDB.update(FoodDBHelper.TABLE_NAME, row, whereClause, whereArgs);
                break;
        }
        myDbHelper.close();
        finish();
    }
}
