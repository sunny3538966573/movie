package com.bw.movie.sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bw.movie.bean.UserInfoBean;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by 1607c王晴
 * date 2019/3/15
 * Describe:
 */
public class MyHelper extends OrmLiteSqliteOpenHelper {
private Context mContext;

    public MyHelper(Context context) {
        super(context, "movie.db", null, 1);
        mContext=context;
    }

    /**
     * 创建表
     * @param sqLiteDatabase
     * @param connectionSource
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,UserInfoBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关于版本
     * @param sqLiteDatabase
     * @param connectionSource
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, UserInfoBean.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        super.close();
        if (mContext!=null){
            mContext=null;
        }

    }
}
