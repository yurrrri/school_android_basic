package ddwucom.mobile.test12.savestate;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends Activity {

    final static String TAG = "MainActivity";

    private MyView vw;
    int x;
    int y;
    int radius;
    int color;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//		x, y 초기 좌표
        x = 300;
        //y = 300; ->getSharedPreferences로 영구저장 실행시에 필요 없어지게됨
        radius = 100;

        SharedPreferences pref = getSharedPreferences("SaveState", 0);
        y = pref.getInt("y", 300);

        color = Color.GREEN;
        Log.d(TAG, "변수 x의 현재값: " + x);
        vw = new MyView(this);
        vw.setFocusable(true);
        vw.setFocusableInTouchMode(true);

        setContentView(vw);
    }

    // onStart 다음에 호출
    // 임시 저장내용 복구
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState == null) {
            x = 300;
        } else {
            x = savedInstanceState.getInt("x");
        }
    }

    // 임시저장
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("x", x);
    }


    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences pref = getSharedPreferences("SaveState", 0);
        SharedPreferences.Editor edit = pref.edit();
        edit.putInt("y", y);
        edit.commit();
    }

    protected class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        public void onDraw(Canvas canvas) {
            Paint p = new Paint();
            p.setColor(color);
            canvas.drawCircle(x, y, radius, p);
        }

        public boolean onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                x = (int) event.getX();
                y = (int) event.getY();
                invalidate();
                return true;
            }
            return false;
        }
    }
}
