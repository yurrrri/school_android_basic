package ddwucom.mobile.exam01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MyView view = new MyView(this);
//        view.setOnTouchListener(view);
//        setContentView(view);

        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        //기본방법 : 클래스 생성 후 적용
        MyClick myClick = new MyClick();
        button1.setOnClickListener(myClick);

        //액티비티가 리스너를 구현
        button2.setOnClickListener(this);

        //익명 클래스 사용
        button3.setOnClickListener(myClickListener);

        //익명 클래스의 임시 객체 사용
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "다섯 번째 익명 클래스 방식", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onMyClick(View v){
        Toast.makeText(MainActivity.this, "안뇽", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "두번째 Activity 방식", Toast.LENGTH_SHORT).show();
    }

    class MyClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //그냥 this라고 쓰면 MyClick을 가리키게 되므로 오류가 남.
            // MainActivity가 Toast를 띄워야하므로 명시적으로 작성
            Toast.makeText(MainActivity.this, "첫번째 버튼", Toast.LENGTH_SHORT).show();
        }
    }

    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "네 번째 익명 클래스 방식", Toast.LENGTH_SHORT).show();
        }
    };

    //뷰를 직접 작성할 경우 뷰에 리스너 인터페이스 구현
    class MyView extends View implements View.OnTouchListener{

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawColor(Color.YELLOW);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Toast.makeText(MainActivity.this, "세 번째 View 자체 구현 방식", Toast.LENGTH_SHORT).show();
            return true;
            //true: 이벤트 수행이 다 끝났고, 이제 그 이벤트는 수행 X임을 의미
            //false: 이벤트 수행이 끝났어도, 이벤트를 처리할 수 있는애면 처리해라
            // 이벤트 처리 완료시 true, 이벤트 처리 계속할 경우 false
            //true시 view에 원래 설정한 이 메소드만 실행하지만, false일 경우 또 이벤트를 처리할 핸들러를 계속 찾아냄
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this, "Touch Event!!!", Toast.LENGTH_LONG).show();
        return true;
        //return super.onTouchEvent(event);
    }
}