package ddwucom.mobile.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout; //변수 선언만!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linear_layout);
        //화면을 만들때 layout에 id를 할당함
    }

//    public void onClick(View v) {
//        //화면을 만들고나서, 버튼을 클릭할때마다 기능을 실행할 수 있도록
//        switch (v.getId()){
//            //case R.id.btnVertical:
//                layout.setOrientation(LinearLayout.VERTICAL);
//                break;
//            case R.id.btnHorizontal:
//                layout.setOrientation(LinearLayout.HORIZONTAL);
//                break;
//
//        }
//    }
}