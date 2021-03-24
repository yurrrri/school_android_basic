package ddwucom.mobile.customviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class MyView extends View {

    int circleX;
    int circleY;
    int circleR;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        circleX = 0;
        circleY = 0;
        circleR = 0;
    }

    public int getCircleR() {
        return circleR;
    }

    public void setCircleR(int circleR) {
        this.circleR = circleR;
    }

    public int getCircleX() {
        return circleX;
    }

    public void setCircleX(int circleX) {
        this.circleX = circleX;
    }

    public int getCircleY() {
        return circleY;
    }

    public void setCircleY(int circleY) {
        this.circleY = circleY;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);

        Paint pnt = new Paint();
        pnt.setColor(Color.CYAN);

        canvas.drawCircle(getCircleX(), getCircleY(), getCircleR(), pnt);
    }
}