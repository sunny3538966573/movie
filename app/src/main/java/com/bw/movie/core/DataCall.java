package com.bw.movie.core;

/**
 * Created by 1607c王晴
 * date 2019/3/12
 * Describe:接口
 */
public interface DataCall<T> {

    void onSuccess(T data);
    void onFail(Throwable throwable);

}
