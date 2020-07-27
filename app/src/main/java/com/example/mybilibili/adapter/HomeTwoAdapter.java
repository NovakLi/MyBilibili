package com.example.mybilibili.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mybilibili.BaseRecyclerAdapter;
import com.example.mybilibili.BaseViewHolder;
import com.example.mybilibili.R;
import com.example.mybilibili.activity.VideoActivity;
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
        holder.setImage(R.id.iv_cover,mContext,list.get(position).getCover());
        holder.setText(R.id.tv_title,list.get(position).getTitle());
        holder.setText(R.id.tv_playcounts,list.get(position).getPlay());
        holder.setText(R.id.tv_commetcounts,list.get(position).getDanmaku());

        LinearLayout linearLayout = holder.getView(R.id.ll_item);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, VideoActivity.class);
                intent.putExtra("vd_title", list.get(position).getTitle());
                mContext.startActivity(intent);
            }
        });
    }
}
