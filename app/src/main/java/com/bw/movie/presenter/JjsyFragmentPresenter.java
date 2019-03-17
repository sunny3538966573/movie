package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.core.DataCall;
import com.bw.movie.core.IRequest;
import com.bw.movie.utils.RetrofitUtils;

import io.reactivex.Observable;

/**
 * Created by 1607c王晴
 * date 2019/3/15
 * Describe:
 */
public class JjsyFragmentPresenter extends BasePresenter {
    private int page=1;
    public JjsyFragmentPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        IRequest iRequest = RetrofitUtils.getInstance().create(IRequest.class);
        boolean refresh = (boolean)args[0];
        if (refresh){
            page = 1;
        }else{
            page++;
        }
        return iRequest.getJjsyBean((int)args[1],(String)args[2],page,10);
    }
}
