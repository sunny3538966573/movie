package com.bw.movie.core;

import com.bw.movie.adapter.ZzsyAdapter;
import com.bw.movie.bean.JjsyBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MuMaBean;
import com.bw.movie.bean.Result;
import com.bw.movie.bean.ZzsyBean;
import com.bw.movie.config.HttpConfig;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 1607c王晴
 * date 2019/3/12
 * Describe:
 */
public interface IRequest {

    @POST(HttpConfig.zhuce_url)
    @FormUrlEncoded
    Observable<Result> getZhuceBean(@Field("nickName") String nickName,
                                    @Field("phone") String phone,
                                    @Field("pwd") String pwd,
                                    @Field("pwd2") String pwd2,
                                    @Field("sex") int sex,
                                    @Field("birthday") String birthday,
                                    @Field("imei") String imei,
                                    @Field("ua") String ua,
                                    @Field("screenSize") String screenSize,
                                    @Field("os") String os,
                                    @Field("email") String email);

    @POST(HttpConfig.login_url)
    @FormUrlEncoded
    Observable<Result<LoginBean>> getLoginBean(@Field("phone") String phone,
                                               @Field("pwd") String pwd);

    @GET(HttpConfig.rmdy_url)
    Observable<Result<List<MuMaBean>>> getMuMaBean(@Header("userId") int userId,
                                                   @Header("sessionId") String sessionId,
                                                   @Query("page") int page,
                                                   @Query("count") int count);


    @GET(HttpConfig.zzsy_url)
    Observable<Result<List<ZzsyBean>>> getZzsyBean(@Header("userId") int userId,
                                                   @Header("sessionId") String sessionId,
                                                   @Query("page") int page,
                                                   @Query("count") int count);

    @GET(HttpConfig.jjsy_url)
    Observable<Result<List<JjsyBean>>> getJjsyBean(@Header("userId") int userId,
                                                   @Header("sessionId") String sessionId,
                                                   @Query("page") int page,
                                                   @Query("count") int count);
}
