package ddwucom.mobile.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataManager dataManager; //데이터를 관리하는 클래스
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;
    int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager();
        editText = findViewById(R.id.editText);
        selectedPosition = 0;

        //데이터 원본 준비
        //데이터 매니저 사용
        ArrayList<String> subjectList = dataManager.getSubjectList();

        //빈 arraylist 생성 후 추가
//        ArrayList<String> subjectList = new ArrayList<String>();
//        subjectList.add("모바일소프트웨어");
//        subjectList.add("네트워크");
//        subjectList.add("웹서비스");
//        subjectList.add("운영체제");
//        subjectList.add("웹프로그래밍2");

        //원본 데이터에 일반 배열을 사용할 경우
       // String[] subjectList = {"모바일소프트웨어", "네트워크", "웹서비스", "운영체제", "웹프로그래밍2"};

        //별도의 arrays.xml 파일 생성
//        String[] subjectList = getResources().getStringArray(R.array.subjectList);

        //어댑터 생성 -> Context, layout, 원본데이터
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjectList);
                                                        //라디오버튼:simple_list_item_single_choice 사용, xml의 checkMode는 singlechoice로 바꿔주기
                                                        //레이아웃마다, xml의 checkmode를 바꿔줘야함
        //어댑터 뷰 준비 및 어댑터 연결
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "pos: " + position, Toast.LENGTH_SHORT).show();
                selectedPosition = position; //클릭한 항목의 position 변수에 저장해서 기록
                String subject = dataManager.getItem(position);
                editText.setText(subject);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dataManager.removeData(position);
                adapter.notifyDataSetChanged(); //원본 데이터를 수정 및 삭제 후 어댑터에 변경을 반드시 알려야함
                return true;
            }
        });
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                dataManager.addData(editText.getText().toString());
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
