package com.bw.movie.fragment.film;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.adapter.RmdyFragmentAdapter;
import com.bw.movie.base.WDFragment;
import com.bw.movie.bean.MuMaBean;
import com.bw.movie.bean.Result;
import com.bw.movie.core.DataCall;
import com.bw.movie.presenter.RmdyFragmentPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 1607c王晴
 * date 2019/3/16
 * Describe:
 */
public class RmdyFragment extends WDFragment implements XRecyclerView.LoadingListener {

    @BindView(R.id.xrecy_rmdy)
    XRecyclerView xrecyRmdy;
    Unbinder unbinder;
    private RmdyFragmentPresenter rmdyFragmentPresenter;
    private RmdyFragmentAdapter rmdyFragmentAdapter;
    private Handler handler=new Handler();

    @Override
    public String getPageName() {
        return "热门电影的fragment";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rmdy_fragment;
    }

    /**
     * 加载网络数据
     */
    @Override
    protected void initView() {
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        xrecyRmdy.setLayoutManager(linearLayoutManager);
        //适配器
        rmdyFragmentAdapter = new RmdyFragmentAdapter(getContext());
        xrecyRmdy.setAdapter(rmdyFragmentAdapter);
        //网络请求数据
        rmdyFragmentPresenter = new RmdyFragmentPresenter(new RmdyFragmentCall());
        rmdyFragmentPresenter.reqeust(true, userInfo.getUserId(), userInfo.getSessionId());

        xrecyRmdy.setLoadingListener(this);

    }

    class RmdyFragmentCall implements DataCall<Result<List<MuMaBean>>> {

        @Override
        public void onSuccess(Result<List<MuMaBean>> data) {
            xrecyRmdy.refreshComplete();
            xrecyRmdy.loadMoreComplete();
            if (data.getStatus().equals("0000")) {
                Toast.makeText(getContext(), data.getMessage(), Toast.LENGTH_SHORT).show();
                rmdyFragmentAdapter.addAll(data.getResult());
                rmdyFragmentAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFail(Throwable throwable) {
            Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        rmdyFragmentPresenter.unBind();
    }


    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
             if (rmdyFragmentPresenter.isRunning()){//正在运行
                 xrecyRmdy.refreshComplete();
                 return;
             }
             rmdyFragmentPresenter.reqeust(true, userInfo.getUserId(), userInfo.getSessionId());
            }
        },2000);
    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (rmdyFragmentPresenter.isRunning()){//正在运行
                    xrecyRmdy.loadMoreComplete();
                    return;
                }
                rmdyFragmentPresenter.reqeust(true, userInfo.getUserId(), userInfo.getSessionId());
            }
        },2000);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
