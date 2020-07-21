package com.example.mybilibili.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mybilibili.BaseActivity;
import com.example.mybilibili.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.tv_search_cancel)
    TextView tvSearchCancel;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.rv_search)
    RecyclerView rvSearch;
    @BindView(R.id.et_search)
    EditText etSearch;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 正在输入的时候
//                ToastUtils.showToastShort(String.valueOf(s.length()));

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() <= 0) {
//                    tvSearch.setBackgroundResource(R.drawable.search_noinput);
                    tvSearch.setTextColor(getResources().getColor(R.color.search_cancel));
                    tvSearch.setEnabled(false);
                } else {
//                    tvSearch.setBackgroundResource(R.drawable.search_input);
                    tvSearch.setTextColor(getResources().getColor(R.color.search_input));
                    tvSearch.setEnabled(true);
                }
            }
        });
    }

    @OnClick({R.id.tv_search, R.id.tv_search_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search:
                break;
            case R.id.tv_search_cancel:
                finish();
                break;
        }
    }
}
