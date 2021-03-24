package ddwu.com.mobile.exam.mycircletest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyCircle myCircle;
    private int r;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Custom View 객체*/
        myCircle = findViewById(R.id.myCircle);
        r = myCircle.getR();

        registerForContextMenu(myCircle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.memu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.bigger:
                r+=10;
                myCircle.setR(r);
                myCircle.invalidate();
                break;
            case R.id.smaller:
                r-=10;
                myCircle.setR(r);
                myCircle.invalidate();
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch(v.getId()){
            case R.id.myCircle:
                getMenuInflater().inflate(R.menu.menu_context, menu);
                onContextItemSelected(menu.getItem(id));
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.red:
                id = 0;
                myCircle.setColor(Color.RED);
                myCircle.invalidate();
                item.setChecked(true);
                break;
            case R.id.green:
                id = 1;
                myCircle.setColor(Color.GREEN);
                myCircle.invalidate();
                item.setChecked(true);
                break;
            case R.id.blue:
                id = 2;
                myCircle.setColor(Color.BLUE);
                myCircle.invalidate();
                item.setChecked(true);
                break;
        }
        return super.onContextItemSelected(item);
    }
}