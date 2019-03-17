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
public class RegistPresenter extends BasePresenter {
    public RegistPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        IRequest iRequest = RetrofitUtils.getInstance().create(IRequest.class);
        return iRequest.getZhuceBean((String)args[0],(String) args[1],(String) args[2],(String) args[3],(int) args[4],(String) args[5],(String) args[6],(String) args[7],(String) args[8],(String) args[9],(String) args[10]);//动态传参;
    }
}
