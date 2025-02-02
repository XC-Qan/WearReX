package cn.rexwear.wearrex.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.rexwear.wearrex.R;
import cn.rexwear.wearrex.utils.GetSharedPreferences;
import cn.rexwear.wearrex.utils.TimeThread;

public class WelcomeActivity extends AppCompatActivity {
    public final static String TAG = "Wear ReX TAG";
    TextView textViewTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTime = findViewById(R.id.time);
        TimeThread timeThread = new TimeThread(textViewTime);   //新建一个获取时间的进程
        timeThread.start();     //开始获取时间
        if (GetSharedPreferences.getInstance(WelcomeActivity.this).getUserIsExperiment()) {
            startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
            finish();
        }
        if (GetSharedPreferences.getInstance(WelcomeActivity.this).getUserID() != -1) {
            startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
            finish();
        }
    }


    //https://github.com/XC-Qan/WearReX/issues/6
/*    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK ) {
            //do something.
            return true;
        } else {
            return super.dispatchKeyEvent(event);
        }
    }*/



}