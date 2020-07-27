package com.example.mybilibili.activity;

import android.view.View;

import com.example.mybilibili.BaseActivity;
import com.example.mybilibili.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.BindView;

public class VideoActivity extends BaseActivity {
    @BindView(R.id.vd_stdvp)
    StandardGSYVideoPlayer vdStdvp;

    String url = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    protected void initData() {
        String vd_title = getIntent().getStringExtra("vd_title");
        vdStdvp.setUpLazy(url, false, null, null, vd_title);
        //title可见
        vdStdvp.getTitleTextView().setVisibility(View.VISIBLE);
        //设置返回键
        vdStdvp.getBackButton().setVisibility(View.GONE);
        vdStdvp.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vdStdvp.startWindowFullscreen(VideoActivity.this, false, true);
            }
        });
        //防止错位设置
//        vdStdvp.setPlayTag(TAG);
//        vdStdvp.setPlayPosition(position);
        //是否根据视频尺寸，自动选择竖屏全屏或者横屏全屏
        vdStdvp.setAutoFullWithSize(true);
        //音频焦点冲突时是否释放
        vdStdvp.setReleaseWhenLossAudio(false);
        //全屏动画
        vdStdvp.setShowFullAnimation(true);
        //小屏时不触摸滑动
        vdStdvp.setIsTouchWiget(false);
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onBackPressed() {
        if (GSYVideoManager.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
    }
}
