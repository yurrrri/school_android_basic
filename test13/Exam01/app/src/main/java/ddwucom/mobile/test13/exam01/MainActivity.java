package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
        myDbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v) {

        SQLiteDatabase myDB = myDbHelper.getReadableDatabase();

        switch(v.getId()) {
            case R.id.btnSelect:
                /*
                된장찌개만 읽고싶으면 :
                String selection = "food=?";
                String[] selectArgs = new String[]{"된장찌개"};
                후 query 인수에 집어넣기
                sql문 => myDB.rawQuery("select * from " +FoodDBHelper.TABLE_NAME + " where food='된장찌개'", null);

                 */
                Cursor cursor =
                        myDB.query(FoodDBHelper.TABLE_NAME, null, null, null, null, null, null, null);

                String result = "";
                while (cursor.moveToNext()){
                    result+=cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID))+". ";
                    result+=cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD))+" ";
                    result+="("+cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION))+")\n";
                }

                tvDisplay.setText(result);
                cursor.close();

                break;
            case R.id.btnAdd:
                Intent add_intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(add_intent);
                break;

            case R.id.btnUpdate:
                Intent update_intent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(update_intent);
                break;
            case R.id.btnRemove:
                Intent remove_intent = new Intent(MainActivity.this, RemoveActivity.class);
                startActivity(remove_intent);
                break;
        }
        myDbHelper.close();
    }

}
