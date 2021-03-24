package ddwucom.mobile.menu_test01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.jjajang:
                Toast.makeText(this, "존맛탱!!!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.jjamgbbong:
                Toast.makeText(this, "개존맛", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onMenuClick(MenuItem item){
        switch(item.getItemId()){
            case R.id.gimchi:
                Toast.makeText(this, "내 영원의 짝궁 개존맛", Toast.LENGTH_SHORT).show();
                break;
            case R.id.soondubu:
                Toast.makeText(this, "가끔 개땡길떄 있음", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
