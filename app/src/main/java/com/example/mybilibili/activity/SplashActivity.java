package com.example.mybilibili.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.example.mybilibili.BaseActivity;
import com.example.mybilibili.R;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {
    @BindView(R.id.tv_splash_count)
    TextView tvSplashCount;

    private int seconds = 3;
//    private Handler mhandler = new Handler() {
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 100) {
//                if (seconds > 0) {
//                    --seconds;
//                    tvSplashCount.setText(seconds + "S");
//                    mhandler.sendEmptyMessageDelayed(100, 1000);
//                } else {
//                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }
//        }
//
//    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        CountDownTimer timer = new CountDownTimer(3400,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvSplashCount.setText(millisUntilFinished / 1000 + "S");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();

        tvSplashCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void initView() {
//        mhandler.sendEmptyMessageDelayed(100, 1000);
    }
}
