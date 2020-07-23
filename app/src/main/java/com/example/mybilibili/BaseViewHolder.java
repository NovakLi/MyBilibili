package com.example.mybilibili;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private SparseArrayCompat<View> mViews;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        mViews = new SparseArrayCompat<>();
    }
    //获得布局
    public <V extends View> V getView(@IdRes int res) {
        View view = mViews.get(res);
        if (view == null) {
            view = itemView.findViewById(res);
            mViews.put(res, view);
        }
        return (V) view;
    }
    public BaseViewHolder setText(@IdRes int res, CharSequence text) {
        TextView textView = getView(res);
        textView.setText(text);
        return this;
    }

    public BaseViewHolder setImage(@IdRes int res, Context context, String url) {
        ImageView imageView = getView(res);
        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher).centerCrop().into(imageView);
        return this;
    }

    public void setOnItemClickListener(@IdRes int res, View.OnClickListener onClickListener) {
        View view = getView(res);
        view.setOnClickListener(onClickListener);
    }
}
