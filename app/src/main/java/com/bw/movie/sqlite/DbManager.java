package com.bw.movie.sqlite;

import android.content.Context;

import com.bw.movie.bean.UserInfoBean;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by 1607c王晴
 * date 2019/3/15
 * Describe:
 */
public class DbManager {
    private Dao<UserInfoBean,String> dao;

    public DbManager(Context context)throws SQLException {
        MyHelper myHelper = new MyHelper(context);
        dao=myHelper.getDao(UserInfoBean.class);
    }

    public Dao<UserInfoBean, String> getUserDao() {
        return dao;
    }
}
