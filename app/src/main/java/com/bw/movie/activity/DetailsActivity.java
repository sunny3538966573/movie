package com.bw.movie.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.adapter.DetailsAdapter;
import com.bw.movie.base.WDActivity;
import com.bw.movie.fragment.film.JjsyFragment;
import com.bw.movie.fragment.film.RmdyFragment;
import com.bw.movie.fragment.film.ZzryFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends WDActivity {


    @BindView(R.id.location_details)
    ImageView locationDetails;
    @BindView(R.id.textview_details)
    TextView textviewDetails;
    @BindView(R.id.search_rl)
    RelativeLayout searchRl;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.vp_details)
    ViewPager vpDetails;
    @BindView(R.id.rb_01)
    RadioButton rb01;
    @BindView(R.id.rb_02)
    RadioButton rb02;
    @BindView(R.id.rb_03)
    RadioButton rb03;
    @BindView(R.id.back_details)
    ImageView backDetails;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView() {
        List<Fragment> list = new ArrayList<>();
        list.add(new ZzryFragment());
        list.add(new RmdyFragment());
        list.add(new JjsyFragment());
        DetailsAdapter detailsAdapter = new DetailsAdapter(getSupportFragmentManager(), list);
        vpDetails.setAdapter(detailsAdapter);
        /**
         * 页面改变监听
         */
        vpDetails.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //页面滑动的时候，下部按钮进行切换
                rg.check(rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        /**
         * 改变按钮的监听
         */
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               /* switch (checkedId) {
                    case R.id.rb_01:
                        vpDetails.setCurrentItem(0, false);
                        //rb01.setTextColor(Color.WHITE);
                        break;
                    case R.id.rb_02:
                        vpDetails.setCurrentItem(1, false);
                       //rb02.setTextColor(Color.WHITE);
                        break;
                    case R.id.rb_03:
                        vpDetails.setCurrentItem(2, false);
                        //rb03.setTextColor(Color.WHITE);
                        break;

                }*/
                /**
                 * 切换标签
                 */
                if (checkedId == R.id.rb_01) {
                    vpDetails.setCurrentItem(0, false);
                    rb01.setTextColor(Color.WHITE);
                    rb02.setTextColor(Color.BLACK);
                    rb03.setTextColor(Color.BLACK);
                } else if (checkedId == R.id.rb_02) {
                    vpDetails.setCurrentItem(1, false);
                    rb01.setTextColor(Color.BLACK);
                    rb02.setTextColor(Color.WHITE);
                    rb03.setTextColor(Color.BLACK);
                } else if (checkedId == R.id.rb_03) {
                    vpDetails.setCurrentItem(2, false);
                    rb01.setTextColor(Color.BLACK);
                    rb02.setTextColor(Color.BLACK);
                    rb03.setTextColor(Color.WHITE);
                }
            }
        });
        backDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void destoryData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
