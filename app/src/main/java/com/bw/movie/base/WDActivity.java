package com.bw.movie.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.bw.movie.bean.UserInfoBean;
import com.bw.movie.sqlite.DbManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import butterknife.ButterKnife;
import me.jessyan.autosize.internal.CancelAdapt;
import me.jessyan.autosize.internal.CustomAdapt;

public abstract class WDActivity extends AppCompatActivity implements CustomAdapt,CancelAdapt {

    public final static int PHOTO = 0;// 相册选取
    public final static int CAMERA = 1;// 拍照
    public Dialog mLoadDialog;// 加载框
    /**
     * 记录处于前台的Activity
     */
    private static WDActivity mForegroundActivity = null;
    private Dao<UserInfoBean, String> userDao;
    private List<UserInfoBean> userInfoBeans;
    private UserInfoBean userInfoBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLoad();
        setContentView(getLayoutId());
        ButterKnife.bind(this);//绑定布局

        try {
            userDao = new DbManager(this).getUserDao();
            userInfoBeans = userDao.queryForAll();
            if (userInfoBeans!=null&&userInfoBeans.size()>0){
                userInfoBean = userInfoBeans.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        initView();
    }
    /**
     * 设置layoutId
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 清除数据
     */
    protected abstract void destoryData();

    /**
     * @param mActivity 传送Activity的
     */
    public void intent(Class mActivity) {
        Intent intent = new Intent(this, mActivity);
        startActivity(intent);
    }

    /**
     * @param mActivity 传送Activity的
     * @param bundle
     */
    public void intent(Class mActivity, Bundle bundle) {
        Intent intent = new Intent(this, mActivity);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 初始化加载框
     */
    private void initLoad() {
        mLoadDialog = new ProgressDialog(this);// 加载框
        mLoadDialog.setCanceledOnTouchOutside(false);
        mLoadDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode,
                                 KeyEvent event) {
                if (mLoadDialog.isShowing() && keyCode == KeyEvent.KEYCODE_BACK) {
                    cancelLoadDialog();
                    mLoadDialog.cancel();
                }
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destoryData();
    }

    //取消操作：请求或者其他
    public void cancelLoadDialog() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mForegroundActivity = this;
    }

    /**
     * 获取当前处于前台的activity
     */
    public static WDActivity getForegroundActivity() {
        return mForegroundActivity;
    }

    /**
     * 得到图片的路径
     *
     * @param fileName
     * @param requestCode
     * @param data
     * @return
     */
    public String getFilePath(String fileName, int requestCode, Intent data) {
        if (requestCode == CAMERA) {
            return fileName;
        } else if (requestCode == PHOTO) {
            Uri uri = data.getData();
            String[] proj = {MediaStore.Images.Media.DATA};
            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
            int actual_image_column_index = actualimagecursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualimagecursor.moveToFirst();
            String img_path = actualimagecursor
                    .getString(actual_image_column_index);
            // 4.0以上平台会自动关闭cursor,所以加上版本判断,OK
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH)
                actualimagecursor.close();
            return img_path;
        }
        return null;
    }

    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {
        return 640;
    }


}
