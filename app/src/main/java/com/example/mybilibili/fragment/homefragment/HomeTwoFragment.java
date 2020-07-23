package com.example.mybilibili.fragment.homefragment;

import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybilibili.BaseFragment;
import com.example.mybilibili.R;
import com.example.mybilibili.adapter.HomeTwoAdapter;
import com.example.mybilibili.bean.HomeBean;
import com.example.mybilibili.contact.ApiConfig;
import com.example.mybilibili.https.HttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeTwoFragment extends BaseFragment {
    @BindView(R.id.rv_home2)
    RecyclerView rvHome2;
    @BindView(R.id.srl_home2)
    SmartRefreshLayout srlHome2;
    @BindView(R.id.tv_home2tab_title)
    TextView tvHome2tabTitle;

    private SmartRefreshLayout srlHome;
    private List<HomeBean.ResultBean.BodyBean> list;
    private HomeTwoAdapter mAdapter;
    private int page = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_two;
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        mAdapter = new HomeTwoAdapter(getContext(),R.layout.item_home2,list);
        rvHome2.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvHome2.setAdapter(mAdapter);
        sendData();
    }

    @Override
    protected void initView() {
        //刷新
        srlHome2.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                page = 1;
                sendData();
                refreshLayout.finishRefresh();
            }
        });

        //加载
        srlHome2.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                ++page;
                sendData();
                refreshLayout.finishLoadMore();
            }
        });
    }

    private void sendData() {
        HttpUtils.sendGET(ApiConfig.HOME_URL, new HttpUtils.OnResponseListener() {
            @Override
            public void onResponse(String string) {
                Log.e("TAG", "onResponse: "+string);
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    JSONArray jsonArray = jsonObject.getJSONArray("result").getJSONObject(0).getJSONArray("body");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        list.add(new HomeBean.ResultBean.BodyBean(obj.getString("title"),
                                obj.getString("cover"),
                                obj.getString("play"),
                                obj.getString("danmaku")));
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.notifyDataSetChanged();
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
