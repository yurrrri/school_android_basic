package ddwucom.mobile.customviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

        private MyView myView;
        Random random;
        int count;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            myView = findViewById(R.id.myView);
            random = new Random();
            count = 0;
        }

        public void onClick(View v) {
            if (count==0) {
                myView.setCircleR(80);
                myView.setCircleX(100);
                myView.setCircleY(100);

                myView.invalidate();
            }

            else{
                myView.setCircleR(random.nextInt(51)+50);
                myView.setCircleX(random.nextInt(myView.getWidth()));
                myView.setCircleY(random.nextInt(myView.getHeight()));

                myView.invalidate();
            }

            count++;
    }
}
