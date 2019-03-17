package com.bw.movie.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.bw.movie.R;
import com.bw.movie.base.WDActivity;
import com.bw.movie.bean.Result;
import com.bw.movie.core.DataCall;
import com.bw.movie.presenter.RegistPresenter;
import com.bw.movie.utils.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistActivity extends WDActivity {

    @BindView(R.id.regist_nike)
    EditText registNike;
    @BindView(R.id.regist_sex)
    EditText registSex;
    @BindView(R.id.regist_date)
    EditText registDate;
    @BindView(R.id.regist_phone)
    EditText registPhone;
    @BindView(R.id.regist_email)
    EditText registEmail;
    @BindView(R.id.regist_pwd)
    EditText registPwd;
    @BindView(R.id.btn_regist)
    Button btnRegist;
    private int sexNum;
    private final String TAG="RegistActivity";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regist;
    }

    /**
     * 加载布局
     */
    @Override
    protected void initView() {

        btnRegist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final String nikename = registNike.getText().toString().trim();
                final String sex = registSex.getText().toString().trim();
                if (sex.equals("男")){
                    sexNum=1;
                }else if (sex.equals("女")){
                    sexNum=2;
                }
                final String sj = registDate.getText().toString().trim();
                final String phone = registPhone.getText().toString();
                Log.i(TAG, "initView: "+phone);
                Log.i(TAG, "initView1: "+sex);
                final String email = registEmail.getText().toString().trim();
                String pwd = registPwd.getText().toString().trim();
                final String encrypt = EncryptUtil.encrypt(pwd);
                RegistPresenter registPresenter = new RegistPresenter(new RegistCall());
                registPresenter.reqeust(nikename,phone,encrypt,encrypt,sexNum,sj,"123456","小米","5.0","android",email);

            }
        });
    }

    class RegistCall implements DataCall<Result>{

        @Override
        public void onSuccess(Result data) {
            if (data.getStatus().equals("0000")){
                Toast.makeText(RegistActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(RegistActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFail(Throwable throwable) {
            Toast.makeText(RegistActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 销毁数据
     */
    @Override
    protected void destoryData() {

    }

}
