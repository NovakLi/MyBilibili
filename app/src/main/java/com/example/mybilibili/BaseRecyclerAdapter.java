package com.example.mybilibili;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;
    private int inflate;
    private List<T> list;

    public BaseRecyclerAdapter(Context mContext, int inflate, List<T> list) {
        this.mContext = mContext;
        this.inflate = inflate;
        this.list = list;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(inflate, parent,false);
        BaseViewHolder viewHolder = new BaseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        convert(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected abstract void convert(BaseViewHolder holder, int position);
}
