package ddwucom.mobile.test06.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyView myView;
    float circleX, circleY;
    int paintColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = (MyView) findViewById(R.id.myView);

        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                circleX = event.getX();
                circleY = event.getY();

                myView.setPosX(circleX);
                myView.setPosY(circleY);

                myView.invalidate();

                return false;
            }
        });

        myView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                if (myView.getPaintColor()==Color.CYAN)
                    paintColor = Color.BLUE;
                else
                    paintColor = Color.CYAN;
                myView.setPaintColor(paintColor);

                myView.invalidate();
                return true;
            }
        });
    }
}
