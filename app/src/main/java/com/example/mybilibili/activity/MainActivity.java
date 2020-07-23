package com.example.mybilibili.activity;

import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.FragmentTransaction;

import com.example.mybilibili.BaseActivity;
import com.example.mybilibili.R;
import com.example.mybilibili.contact.EventMessage;
import com.example.mybilibili.fragment.ChannelFragment;
import com.example.mybilibili.fragment.DynamicFragment;
import com.example.mybilibili.fragment.HomeFragment;
import com.example.mybilibili.fragment.MeFragment;
import com.example.mybilibili.fragment.VipFragment;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_home)
    FrameLayout flHome;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_channel)
    RadioButton rbChannel;
    @BindView(R.id.rb_dynamic)
    RadioButton rbDynamic;
    @BindView(R.id.rb_vip)
    RadioButton rbVip;
    @BindView(R.id.rb_me)
    RadioButton rbMe;
    @BindView(R.id.rg_bottom)
    RadioGroup rgBottom;

    private HomeFragment homeFragment;
    private ChannelFragment channelFragment;
    private DynamicFragment dynamicFragment;
    private VipFragment vipFragment;
    private MeFragment meFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        homeFragment = new HomeFragment(this);
        channelFragment = new ChannelFragment();
        dynamicFragment = new DynamicFragment();
        vipFragment = new VipFragment();
        meFragment = new MeFragment();

        //刚进APP时默认设置
        rbHome.setChecked(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_home, homeFragment).commit();

        //底部导航条监听事件
        rgBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (checkedId) {
                    case R.id.rb_home:
                        transaction.replace(R.id.fl_home, homeFragment);
                        break;
                    case R.id.rb_channel:
                        transaction.replace(R.id.fl_home, channelFragment);
                        break;
                    case R.id.rb_dynamic:
                        transaction.replace(R.id.fl_home, dynamicFragment);
                        break;
                    case R.id.rb_vip:
                        transaction.replace(R.id.fl_home, vipFragment);
                        break;
                    case R.id.rb_me:
                        transaction.replace(R.id.fl_home, meFragment);
                        break;
                }
                transaction.commit();
            }
        });
    }
//    @Subscribe()
//    public void getEventMessage(EventMessage message) {
//        switch (message.getType()) {
//            case 0:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_home, meFragment);
//                rbMe.setChecked(true);
//        }
//    }
}
