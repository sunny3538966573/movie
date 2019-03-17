package com.bw.movie.base;


import com.bw.movie.bean.UserInfoBean;
import com.bw.movie.sqlite.DbManager;
import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.SQLException;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.jessyan.autosize.utils.LogUtils;

public abstract class WDFragment extends Fragment {
	private Unbinder unbinder;
	private Dao<UserInfoBean, String> userDao;
	private List<UserInfoBean> userInfoBeans;
	protected UserInfoBean userInfo;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 每次ViewPager要展示该页面时，均会调用该方法获取显示的View
		long time = System.currentTimeMillis();
		View view = inflater.inflate(getLayoutId(),container,false);
		unbinder = ButterKnife.bind(this,view);
		try {
			userDao = new DbManager(getActivity()).getUserDao();
			userInfoBeans = userDao.queryForAll();
			if (userInfoBeans!=null&&userInfoBeans.size()>0){
				userInfo = userInfoBeans.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initView();
		LogUtils.e(this.toString()+"页面加载使用："+(System.currentTimeMillis()-time));
		return view;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}

	//	@Override
//	public void onResume() {
//		super.onResume();
//		if (!MTStringUtils.isEmpty(getPageName()))
//			MobclickAgent.onPageStart(getPageName()); // 统计页面
//	}
//
//	@Override
//	public void onPause() {
//		super.onPause();
//		if (!MTStringUtils.isEmpty(getPageName()))
//			MobclickAgent.onPageEnd(getPageName());// 统计页面
//	}

	/**
	 * 设置页面名字
	 */
	public abstract String getPageName();
	/**
	 * 设置layoutId
	 * @return
	 */
	protected abstract int getLayoutId();

	/**
	 * 初始化视图
	 */
	protected abstract void initView();
}
