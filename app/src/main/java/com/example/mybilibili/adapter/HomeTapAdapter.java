package com.example.mybilibili.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class HomeTapAdapter extends FragmentPagerAdapter {
    private String[] tabs;
    private List<Fragment> list;

    public HomeTapAdapter(@NonNull FragmentManager fm, List<Fragment> list, String[] tabs) {
        super(fm);
        this.list = list;
        this.tabs = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
