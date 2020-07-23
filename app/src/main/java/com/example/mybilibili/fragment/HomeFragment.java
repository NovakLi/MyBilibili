package com.example.mybilibili.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mybilibili.BaseFragment;
import com.example.mybilibili.R;
import com.example.mybilibili.activity.SearchActivity;
import com.example.mybilibili.adapter.HomeTapAdapter;
import com.example.mybilibili.fragment.homefragment.HomeEightFragment;
import com.example.mybilibili.fragment.homefragment.HomeFiveFragment;
import com.example.mybilibili.fragment.homefragment.HomeFourFragment;
import com.example.mybilibili.fragment.homefragment.HomeOneFragment;
import com.example.mybilibili.fragment.homefragment.HomeSevenFragment;
import com.example.mybilibili.fragment.homefragment.HomeSixFragment;
import com.example.mybilibili.fragment.homefragment.HomeThreeFragment;
import com.example.mybilibili.fragment.homefragment.HomeTwoFragment;
import com.example.mybilibili.utils.DimensionUtils;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.vp_home)
    ViewPager vpHome;
    @BindView(R.id.tl_title)
    TabLayout tlTitle;
    @BindView(R.id.circl_login)
    CircleImageView circlLogin;
    @BindView(R.id.home_game)
    ImageView homeGame;
    @BindView(R.id.home_message)
    ImageView homeMessage;

    private HomeOneFragment oneFragment;
    private HomeTwoFragment twoFragment;
    private HomeThreeFragment threeFragment;
    private HomeFourFragment fourFragment;
    private HomeFiveFragment fiveFragment;
    private HomeSixFragment sixFragment;
    private HomeSevenFragment sevenFragment;
    private HomeEightFragment eightFragment;
    private List<Fragment> fragmentList;
    private HomeTapAdapter tapAdapter;
    private MeFragment meFragment;
    private AppCompatActivity mContext;

    private String[] tabs = {"直播", "推荐", "热门", "追番", "影视", "说唱区", "抗击肺炎", "小康"};

    public HomeFragment(AppCompatActivity mContext) {
        this.mContext = mContext;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        oneFragment = new HomeOneFragment();
        twoFragment = new HomeTwoFragment();
        threeFragment = new HomeThreeFragment();
        fourFragment = new HomeFourFragment();
        fiveFragment = new HomeFiveFragment();
        sixFragment = new HomeSixFragment();
        sevenFragment = new HomeSevenFragment();
        eightFragment = new HomeEightFragment();
        meFragment = new MeFragment();
        fragmentList = new ArrayList<>();
        fragmentList.add(oneFragment);
        fragmentList.add(twoFragment);
        fragmentList.add(threeFragment);
        fragmentList.add(fourFragment);
        fragmentList.add(fiveFragment);
        fragmentList.add(sixFragment);
        fragmentList.add(sevenFragment);
        fragmentList.add(eightFragment);

        //将子fragment放进适配器
        tapAdapter = new HomeTapAdapter(getChildFragmentManager(), fragmentList, tabs);
        //将适配器绑定VP
        vpHome.setAdapter(tapAdapter);

        //初始设置
        vpHome.setCurrentItem(0);

        vpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //滑动绑定

        tlTitle.setupWithViewPager(vpHome);
        tlTitle.getTabAt(1).select();
    }

    @Override
    protected void initView() {
//        llSearch.setPadding(DimensionUtils.px2dp(getContext(), 1000), 0, 0, 0);
    }

    @OnClick(R.id.ll_search)
    public void onViewClicked() {
        intent2Activity(SearchActivity.class);
    }

    @OnClick({R.id.circl_login, R.id.home_game, R.id.home_message})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.circl_login:
//                EventBus.getDefault().register();
                break;
            case R.id.home_game:
                break;
            case R.id.home_message:
                break;
        }
    }
}
