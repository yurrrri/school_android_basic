package ddwucom.mobile.test08.listView_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SubjectManager subjectManager; //데이터 관리 클래스
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter;
    Button btnUpdate;
    Button btnInsert;
    ListView listView;
    int selectedpos;
    EditText etItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectManager = new SubjectManager();
        subjectList = subjectManager.getSubjectList();

        etItem = findViewById(R.id.etItem);
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, subjectList
        );

        //어댑터뷰 준비 및 어댑터 연결
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //항목 클릭 시 해당 항목을 수정하기 위해 별도의 변수 생성 후 위치 기록
                selectedpos = position;
                etItem.setText(subjectManager.getItem(selectedpos));
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                subjectManager.removeData(position);
                adapter.notifyDataSetChanged(); //데이터의 변경 알림 필수 !
                return false;
            }
        });
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnInsert:
                subjectManager.addData(etItem.getText().toString());
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnUpdate:
                subjectManager.modifyData(selectedpos, etItem.getText().toString());
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
