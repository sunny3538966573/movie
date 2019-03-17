package com.bw.movie.fragment.film;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.ZzryFragmentAdapter;
import com.bw.movie.base.WDFragment;
import com.bw.movie.bean.Result;
import com.bw.movie.bean.ZzsyBean;
import com.bw.movie.core.DataCall;
import com.bw.movie.presenter.ZzryFragmentPresenter;
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
public class ZzryFragment extends WDFragment implements XRecyclerView.LoadingListener {
    @BindView(R.id.xrecy_zzry)
    XRecyclerView xrecyZzry;
    Unbinder unbinder;
    private ZzryFragmentPresenter zzryFragmentPresenter;
    private ZzryFragmentAdapter zzryFragmentAdapter;
    private Handler handler = new Handler();

    @Override
    public String getPageName() {
        return "正在热映的ZzryFragment";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zzry_fragment;
    }

    @Override
    protected void initView() {
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        xrecyZzry.setLayoutManager(linearLayoutManager);
        //适配器
        zzryFragmentAdapter = new ZzryFragmentAdapter(getContext());
        xrecyZzry.setAdapter(zzryFragmentAdapter);
        xrecyZzry.setLoadingListener(this);

        zzryFragmentPresenter = new ZzryFragmentPresenter(new ZzryFragmentCall());
        zzryFragmentPresenter.reqeust(true, userInfo.getUserId(), userInfo.getSessionId());

    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (zzryFragmentPresenter.isRunning()) {//正在运行的话
                    xrecyZzry.refreshComplete();
                    return;
                }
                zzryFragmentPresenter.reqeust(true, userInfo.getUserId(), userInfo.getSessionId());
            }
        }, 1000);
    }

    /**
     * 加载更多
     */
    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (zzryFragmentPresenter.isRunning()) {
                    xrecyZzry.loadMoreComplete();
                    return;
                }
                zzryFragmentPresenter.reqeust(true, userInfo.getUserId(), userInfo.getSessionId());
            }
        }, 1000);

    }

    class ZzryFragmentCall implements DataCall<Result<List<ZzsyBean>>> {

        @Override
        public void onSuccess(Result<List<ZzsyBean>> data) {
            xrecyZzry.refreshComplete();
            xrecyZzry.loadMoreComplete();
            if (data.getStatus().equals("0000")) {
                zzryFragmentAdapter.addAll(data.getResult());
                zzryFragmentAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFail(Throwable throwable) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    /**
     * 防止内存泄漏
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        zzryFragmentPresenter.unBind();
    }
}
