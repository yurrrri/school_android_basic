package ddwucom.mobile.test13.exam01;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RemoveActivity extends AppCompatActivity {

    FoodDBHelper myDbHelper;
    EditText etRemoveFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        myDbHelper = new FoodDBHelper(this);
        etRemoveFood = findViewById(R.id.etRemoveFood);
    }

    public void onClick(View v){

        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();

        switch(v.getId()){
            case R.id.btnRemoveFood:
                String whereClause = "food=?";
                String[] whereArgs =new String[]{etRemoveFood.getText().toString()};

                myDB.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);
                break;
        }
        myDbHelper.close();
        finish();
    }
}
