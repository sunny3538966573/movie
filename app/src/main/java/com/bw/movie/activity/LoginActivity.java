package com.bw.movie.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.WDActivity;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.Result;
import com.bw.movie.bean.UserInfoBean;
import com.bw.movie.core.DataCall;
import com.bw.movie.presenter.LoginPresenter;
import com.bw.movie.sqlite.DbManager;
import com.bw.movie.utils.EncryptUtil;
import com.bw.movie.utils.PhoneNumber;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends WDActivity {


    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.go_regist)
    TextView goRegist;
    @BindView(R.id.eye)
    ImageView eye;
    private LoginPresenter loginPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = loginPhone.getText().toString().trim();
                String pwd = loginPwd.getText().toString().trim();
                String encrypt = EncryptUtil.encrypt(pwd);
                //进行正则验证
                boolean mobileNO = PhoneNumber.isMobileNO(phone);
                if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(LoginActivity.this, "手机号或者密码不可以为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (mobileNO) {
                        loginPresenter = new LoginPresenter(new LoginCall());
                        loginPresenter.reqeust(phone, encrypt);
                        //跳转到主页面
                        intent(HomeActivity.class);
                    } else {
                        Toast.makeText(LoginActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
/**
 * 注册
 */
        goRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(RegistActivity.class);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    class LoginCall implements DataCall<Result<LoginBean>> {
        @Override
        public void onSuccess(Result<LoginBean> data) {
            if (data.getStatus().equals("0000")) {
                Toast.makeText(LoginActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                UserInfoBean userInfoBean = data.getResult().getUserInfo();
                userInfoBean.setStats(100);
                userInfoBean.setUserId(data.getResult().getUserId());
                userInfoBean.setSessionId(data.getResult().getSessionId());

                try {
                    Dao<UserInfoBean, String> userDao = new DbManager(LoginActivity.this).getUserDao();
                    //userDao.deleteBuilder().delete();
                    userDao.createOrUpdate(userInfoBean);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                finish();
                overridePendingTransition(R.anim.ac_in, R.anim.ac_out);
            } else {
                Toast.makeText(LoginActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFail(Throwable throwable) {
            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 防止内存泄漏
     */
    @Override
    protected void destoryData() {
        loginPresenter.unBind();
    }

}
