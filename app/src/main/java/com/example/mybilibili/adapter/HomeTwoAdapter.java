package com.example.mybilibili.adapter;

import android.content.Context;

import com.example.mybilibili.BaseRecyclerAdapter;
import com.example.mybilibili.BaseViewHolder;
import com.example.mybilibili.bean.HomeBean;

import java.util.List;

public class HomeTwoAdapter extends BaseRecyclerAdapter<HomeBean.ResultBean.BodyBean>{
    private Context mContext;
    private List<HomeBean.ResultBean.BodyBean> list;

    public HomeTwoAdapter(Context mContext, int inflate, List<HomeBean.ResultBean.BodyBean> list) {
        super(mContext, inflate, list);
        this.mContext = mContext;
        this.list = list;
    }


    @Override
    protected void convert(BaseViewHolder holder, int position) {

    }
}
