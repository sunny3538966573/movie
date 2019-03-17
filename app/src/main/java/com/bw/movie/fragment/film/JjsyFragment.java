package com.bw.movie.fragment.film;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.JjsyFragmentAdapter;
import com.bw.movie.base.WDFragment;
import com.bw.movie.bean.JjsyBean;
import com.bw.movie.bean.Result;
import com.bw.movie.core.DataCall;
import com.bw.movie.presenter.JjsyFragmentPresenter;
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
public class JjsyFragment extends WDFragment implements XRecyclerView.LoadingListener {
    @BindView(R.id.xrecy_jjsy)
    XRecyclerView xrecyJjsy;
    Unbinder unbinder;
    private JjsyFragmentAdapter jjsyFragmentAdapter;
    private JjsyFragmentPresenter jjsyFragmentPresenter;
    private Handler handler=new Handler();

    @Override
    public String getPageName() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.jjsy_fragment;
    }

    @Override
    protected void initView() {
//布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        xrecyJjsy.setLayoutManager(linearLayoutManager);

        jjsyFragmentAdapter = new JjsyFragmentAdapter(getContext());
        xrecyJjsy.setAdapter(jjsyFragmentAdapter);

        //网络请求数据
        jjsyFragmentPresenter = new JjsyFragmentPresenter(new JjsyFragmentCall());
        jjsyFragmentPresenter.reqeust(true, userInfo.getUserId(), userInfo.getSessionId());

        xrecyJjsy.setLoadingListener(this);
    }

    class JjsyFragmentCall implements DataCall<Result<List<JjsyBean>>>{

        @Override
        public void onSuccess(Result<List<JjsyBean>> data) {

            if (data.getStatus().equals("0000")){
                jjsyFragmentAdapter.addAll(data.getResult());
                jjsyFragmentAdapter.notifyDataSetChanged();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        jjsyFragmentPresenter.unBind();
    }

    @Override
    public void onRefresh() {
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        if (jjsyFragmentPresenter.isRunning()){
            xrecyJjsy.refreshComplete();
            return;
        }
        jjsyFragmentPresenter.reqeust(true, userInfo.getUserId(), userInfo.getSessionId());
    }
},2000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (jjsyFragmentPresenter.isRunning()){
                    xrecyJjsy.loadMoreComplete();
                    return;
                }
                jjsyFragmentPresenter.reqeust(true, userInfo.getUserId(), userInfo.getSessionId());
            }
        },2000);
    }
}
