package enis.rnu.checkmyhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
          ImageView splashIcon =(ImageView) findViewById(R.id.imageView2) ;

       Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate) ;
        splashIcon.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mPlayer =MediaPlayer.create(MainActivity.this,R.raw.welcome) ;
                mPlayer.start();
                setVolumeControlStream(AudioManager.STREAM_MUSIC);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(mPlayer!=null){
                    mPlayer.stop();
                    mPlayer.reset();
                    mPlayer.release();
                    Intent intent= new Intent(MainActivity.this,MenuActivity.class) ;
                    startActivity(intent);
                    finish();
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });




    }
}
