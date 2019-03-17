package com.bw.movie.config;

/**
 * Created by 1607c王晴
 * date 2019/3/12
 * Describe:
 */
public class HttpConfig {
    //http://172.17.8.100/movieApi/user/v1/login
    public static final String base_url="http://172.17.8.100/movieApi/";
    public static final String zhuce_url="user/v1/registerUser";

    //http://172.17.8.100/movieApi/user/v1/login
    public static final String login_url="user/v1/login";

    //http://172.17.8.100/movieApi/movie/v1/findHotMovieList
    public static final String rmdy_url="movie/v1/findHotMovieList";

    //http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList
    public static final String zzsy_url="movie/v1/findReleaseMovieList";

    //http://172.17.8.100/movieApi/movie/v1/findComingSoonMovieList
    public static final String jjsy_url="movie/v1/findComingSoonMovieList";

}
