package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.core.DataCall;
import com.bw.movie.core.IRequest;
import com.bw.movie.utils.RetrofitUtils;

import io.reactivex.Observable;

/**
 * Created by 1607c王晴
 * date 2019/3/12
 * Describe:
 */
public class LoginPresenter extends BasePresenter {
    public LoginPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        IRequest iRequest = RetrofitUtils.getInstance().create(IRequest.class);
        return iRequest.getLoginBean((String)args[0],(String) args[1]);
    }
}
