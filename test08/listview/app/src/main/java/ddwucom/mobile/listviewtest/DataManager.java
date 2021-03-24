package ddwucom.mobile.listviewtest;

import java.util.ArrayList;

public class DataManager {
    private ArrayList<String> subjectList;

    public DataManager(){ //생성자 -> 데이터 생성
        subjectList = new ArrayList<String>();
        subjectList.add("모바일소프트웨어");
        subjectList.add("네트워크");
        subjectList.add("웹서비스");
        subjectList.add("운영체제");
        subjectList.add("웹프로그래밍2");
    }

    public ArrayList<String> getSubjectList(){
        return subjectList;
    }

    public String getItem(int pos){
        return subjectList.get(pos);
    }

    //멤버 추가
    public void addData(String newSubject){
        subjectList.add(newSubject);
    }

    //삭제
    public void removeData(int pos){
        subjectList.remove(pos);
    }

    //수정
    public void modifyData(int pos, String subject){
        subjectList.set(pos, subject);
    }
}
