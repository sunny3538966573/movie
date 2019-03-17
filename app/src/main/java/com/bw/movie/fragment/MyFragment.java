package com.bw.movie.fragment;

import com.bw.movie.R;
import com.bw.movie.base.WDFragment;

/**
 * Created by 1607c王晴
 * date 2019/3/15
 * Describe:
 */
public class MyFragment extends WDFragment {
    @Override
    public String getPageName() {
        return "MyFragment";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.my_layout;
    }

    @Override
    protected void initView() {

    }
}
