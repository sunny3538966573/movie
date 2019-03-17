package com.bw.movie.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.WDActivity;
import com.bw.movie.fragment.CinemaFragment;
import com.bw.movie.fragment.FilmFragment;
import com.bw.movie.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends WDActivity {


    @BindView(R.id.home_vp)
    ViewPager homeVp;
    @BindView(R.id.home_film)
    TextView homeFilm;
    @BindView(R.id.home_cinema)
    TextView homeCinema;
    @BindView(R.id.home_my)
    TextView homeMy;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    /**
     * 加载数据
     */
    @Override
    protected void initView() {
        final List<Fragment> list = new ArrayList<>();
        list.add(new FilmFragment());
        list.add(new CinemaFragment());
        list.add(new MyFragment());
        homeVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        homeVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                ChangeBackGround(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }


        });
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){//判断手机状态是否高于 Android4.4
            //设置透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }

        homeFilm.setBackgroundResource(R.drawable.com_icon_film_selected_hdpi);
        donghua();
    }

    private void ChangeBackGround(int i) {
        homeFilm.setBackgroundResource(i == 0 ? R.drawable.com_icon_film_selected_hdpi : R.drawable.com_icon_film_fault_hdpi);
        homeCinema.setBackgroundResource(i == 1 ? R.drawable.com_icon_cinema_selected_hdpi : R.drawable.com_icon_cinema_default_hdpi);
        homeMy.setBackgroundResource(i == 2 ? R.drawable.com_icon_my_selected_hdpi : R.drawable.com_icon_my_default_hdip);
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

    @OnClick({R.id.home_film, R.id.home_cinema, R.id.home_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_film:

                homeVp.setCurrentItem(0, false);
                ChangeBackGround(0);
                donghua();
                break;
            case R.id.home_cinema:
                homeVp.setCurrentItem(1, false);
                ChangeBackGround(1);
                AnimatorSet set1 = new AnimatorSet();
                ObjectAnimator oo1 = ObjectAnimator.ofFloat(homeFilm, "scaleX", 1.0f);
                ObjectAnimator oo2 = ObjectAnimator.ofFloat(homeCinema, "scaleX", 1.17f);
                ObjectAnimator oo3 = ObjectAnimator.ofFloat(homeMy, "scaleX", 1.0f);

                ObjectAnimator oo4 = ObjectAnimator.ofFloat(homeFilm, "scaleY", 1.0f);
                ObjectAnimator oo5 = ObjectAnimator.ofFloat(homeCinema, "scaleY", 1.17f);
                ObjectAnimator oo6 = ObjectAnimator.ofFloat(homeMy, "scaleY", 1.0f);

                set1.playTogether(oo1, oo2, oo3, oo4, oo5, oo6);
                set1.start();
                break;
            case R.id.home_my:
                homeVp.setCurrentItem(2, false);
                ChangeBackGround(2);

                AnimatorSet set2 = new AnimatorSet();
                ObjectAnimator ooo1 = ObjectAnimator.ofFloat(homeFilm, "scaleX", 1.0f);
                ObjectAnimator ooo2 = ObjectAnimator.ofFloat(homeCinema, "scaleX", 1.0f);
                ObjectAnimator ooo3 = ObjectAnimator.ofFloat(homeMy, "scaleX", 1.17f);

                ObjectAnimator ooo4 = ObjectAnimator.ofFloat(homeFilm, "scaleY", 1.0f);
                ObjectAnimator ooo5 = ObjectAnimator.ofFloat(homeCinema, "scaleY", 1.0f);
                ObjectAnimator ooo6 = ObjectAnimator.ofFloat(homeMy, "scaleY", 1.17f);

                set2.playTogether(ooo1, ooo2, ooo3, ooo4, ooo5, ooo6);
                set2.start();
                break;
        }
    }

    private void donghua() {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator o1 = ObjectAnimator.ofFloat(homeFilm, "scaleX", 1.17f);
        ObjectAnimator o2 = ObjectAnimator.ofFloat(homeCinema, "scaleX", 1.0f);
        ObjectAnimator o3 = ObjectAnimator.ofFloat(homeMy, "scaleX", 1.0f);

        ObjectAnimator o4 = ObjectAnimator.ofFloat(homeFilm, "scaleY", 1.17f);
        ObjectAnimator o5 = ObjectAnimator.ofFloat(homeCinema, "scaleY", 1.0f);
        ObjectAnimator o6 = ObjectAnimator.ofFloat(homeMy, "scaleY", 1.0f);

        set.playTogether(o1, o2, o3, o4, o5, o6);
        set.start();

    }
}
