package ddwucom.mobile.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SoundPool soundPool;
    AudioManager audioManager;
    int sound;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //이걸 onClick에 넣으면 로딩하는데 너무 오래걸림.
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound = soundPool.load(this, R.raw.dingdong, 1);
        //audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void onClick(View v){

        switch(v.getId()){
            case R.id.btnToast:
                Toast.makeText(this, "이유리", Toast.LENGTH_SHORT).show();
            case R.id.btnSound:
                soundPool.play(sound, 1, 1, 0, 0, 1);
                break;
            case R.id.btnVibration:
                vibrator.vibrate(500); //0.5초동안 진동 실행
                vibrator.vibrate(new long[]{100, 50, 200, 50}, 0); //진동 여러번 패턴에 맞게
                break;
        }
    }
}
