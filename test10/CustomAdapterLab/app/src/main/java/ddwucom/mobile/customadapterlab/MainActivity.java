package ddwucom.mobile.customadapterlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DataManager dataManager;
    private ArrayList<townData> townDataList;
    private townAdapter townAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager(); //DTO 클래스
        townDataList = dataManager.getSubjectList();

        //어댑터 뷰 준비 및 어댑텨 연결
        townAdapter = new townAdapter(this, R.layout.custom_adapter_view, townDataList);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(townAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dataManager.removeData(position);
                townAdapter.notifyDataSetChanged(); //어댑터에 데이터의 변경 알림
                return true;
            }
        });
    }
}
