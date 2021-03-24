package ddwucom.mobile.dbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FoodDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new FoodDBHelper(this);
        dbHelper.getReadableDatabase(); //이 순간 테이블이 만들어짐(onCreate 1회 호출)
                                        //이 순간 테이블의 구조를 변경할 수 없음. 내용의 변경이 생기면 앱을 제거해야함
    }
}