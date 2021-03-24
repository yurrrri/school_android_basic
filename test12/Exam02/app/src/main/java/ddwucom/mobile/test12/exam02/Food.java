package ddwucom.mobile.test12.exam02;

import java.io.Serializable;

//객체를 intent에 전달하기 위해서 필수적으로 Serializable을 구현해야한다.
public class Food implements Serializable{
    String food;
    String nation;


    public Food(String food, String nation) {
        this.food = food;
        this.nation = nation;
    }

    public String getFood() {
        return food;
    }

    public String getNation() {
        return nation;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return food + "\t\t(" + nation + ")";
    }

}
