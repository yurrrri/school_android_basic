package ddwucom.mobile.customadaptertest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

//맨 처음 오류 발생시 Alt+Enter로 오류해결
public class MyAdapter extends BaseAdapter {

    static final String TAG = "MyAdapter";

    //int count;
    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater inflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList) {

        //count = 0;
        this.context = context; //inflater 객체 생성시 필요
        this.layout = layout; //레이아웃
        this.myDataList = myDataList; //원본 데이터
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //항목의 개수 반환
    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return myDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myDataList.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);

            //Log.d(TAG, "count: "+count++); //한 화면에 뷰가 몇개 만들어지는지 보기 위한 Log

            holder = new ViewHolder();
            holder.tvNo = convertView.findViewById(R.id.tvNo);
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvPhone = convertView.findViewById(R.id.tvPhone);
            holder.btnCheck = convertView.findViewById(R.id.btnCheck);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        //btnCheck.setFocusable(false); //버튼뿐만 아니라 모든 view가 이벤트 처리 가능하도록

        holder.tvNo.setText(String.valueOf(myDataList.get(pos).get_id()));
        holder.tvName.setText(myDataList.get(pos).getName());
        holder.tvPhone.setText(myDataList.get(pos).getPhone());
        holder.btnCheck.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myDataList.get(pos).getPhone() + " 선택", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    //정적 클래스의 변수는 한번 초기화 후 같은 값을 계속 사용함
    static class ViewHolder{
        TextView tvNo;
        TextView tvName;
        TextView tvPhone;
        Button btnCheck;
    }
}
