package ddwucom.mobile.menutest01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MenuActivity";
    final static int MENU_FIRST = 100;
    final static int MENU_SECOND = 200;
    PopupMenu popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        //registerForContextMenu(textView); //view등록

        //popup 구현
        popup = new PopupMenu(this, textView);
        popup.getMenuInflater().inflate(R.menu.menu_main,popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "HI!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popup.show();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.group_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch(v.getId()){
            case R.id.textView:
                menu.setHeaderTitle("Context menu"); //ContextMenu 타이틀주기
                menu.add(0, MENU_FIRST, 0, "FIRST");
                menu.add(0, MENU_SECOND, 0, "SECOND");

                getMenuInflater().inflate(R.menu.menu_context, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case MENU_FIRST:
                break;
            case MENU_SECOND:
                break;
            case R.id.third:
                break;
            case R.id.fourth:
                break;
        }
        return super.onContextItemSelected(item);
    }

    //
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        menu.clear();
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.gitem01:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                break;
            case R.id.gitem02:
                break;
            case R.id.gitem03:
                break;
            case R.id.gitem04:

                break;
        }
        return true;
    }

    public void onMenuItemClick(MenuItem item){
        Log.d(TAG, "Item 01 is clicked !!!!!!!!!!!!");
    }
}
