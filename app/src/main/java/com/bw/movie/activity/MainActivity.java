package com.bw.movie.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.bw.movie.R;
import com.bw.movie.base.WDActivity;

public class MainActivity extends WDActivity {

    private int time = 2;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                if (time <= 0) {
                    Intent intent = new Intent(MainActivity.this, GuideActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.ac_in, R.anim.ac_out);
                    return;
                } else {
                    time--;
                    handler.sendEmptyMessageDelayed(0, 1000);
                }

            }
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    @Override
    protected void destoryData() {
        handler.removeMessages(0);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
