package com.bw.movie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.activity.DetailsActivity;
import com.bw.movie.adapter.JjsyAdapter;
import com.bw.movie.adapter.MuMaAdapter;
import com.bw.movie.adapter.RmdyAdapter;
import com.bw.movie.adapter.ZzsyAdapter;
import com.bw.movie.base.WDFragment;
import com.bw.movie.bean.JjsyBean;
import com.bw.movie.bean.MuMaBean;
import com.bw.movie.bean.Result;
import com.bw.movie.bean.ZzsyBean;
import com.bw.movie.core.DataCall;
import com.bw.movie.presenter.JjsyPresenter;
import com.bw.movie.presenter.MuMaPresenter;
import com.bw.movie.presenter.ZzsyPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * Created by 1607c王晴
 * date 2019/3/15
 * Describe:
 */
public class FilmFragment extends WDFragment {
    @BindView(R.id.film_location)
    ImageView filmLocation;
    @BindView(R.id.textview_location)
    TextView textviewLocation;
    @BindView(R.id.film_search)
    RelativeLayout filmSearch;
    @BindView(R.id.film_rcf)
    RecyclerCoverFlow filmRcf;
    @BindView(R.id.top)
    RelativeLayout top;
    @BindView(R.id.movie_text_xian)
    TextView movieTextXian;
    @BindView(R.id.movie_text_dong)
    TextView movieTextDong;
    @BindView(R.id.textview_rmdy)
    TextView textviewRmdy;
    @BindView(R.id.txt_view)
    View txtView;
    @BindView(R.id.film_rmdy_next)
    ImageView filmRmdyNext;
    @BindView(R.id.recy_rmdy)
    RecyclerView recyRmdy;
    @BindView(R.id.rl_rmdy)
    RelativeLayout rlRmdy;
    @BindView(R.id.textview_zzsy)
    TextView textviewZzsy;
    @BindView(R.id.txt_view1)
    View txtView1;
    @BindView(R.id.film_zzsy_next)
    ImageView filmZzsyNext;
    @BindView(R.id.recy_zzry)
    RecyclerView recyZzry;
    @BindView(R.id.zzsy_rl)
    RelativeLayout zzsyRl;
    @BindView(R.id.txt_zzsy)
    TextView txtZzsy;
    @BindView(R.id.txt_view2)
    View txtView2;
    @BindView(R.id.film_jjsy_next)
    ImageView filmJjsyNext;
    @BindView(R.id.recy_jjsy)
    RecyclerView recyJjsy;
    Unbinder unbinder;
    private MuMaPresenter muMaPresenter;
    private MuMaAdapter muMaAdapter;
    private RmdyAdapter rmdyAdapter;
    private ZzsyAdapter zzsyAdapter;
    private ZzsyPresenter zzsyPresenter;
    private JjsyAdapter jjsyAdapter;

    @Override
    public String getPageName() {
        return "影片的FilmFragment";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.film_layout;
    }

    @Override
    protected void initView() {
        muMaAdapter = new MuMaAdapter(getActivity());
        filmRcf.setAdapter(muMaAdapter);

        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyRmdy.setLayoutManager(linearLayoutManager);
        LinearLayoutManager zzrylinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyZzry.setLayoutManager(zzrylinearLayoutManager);
        LinearLayoutManager jjlinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyJjsy.setLayoutManager(jjlinearLayoutManager);

        //适配器
        rmdyAdapter = new RmdyAdapter(getActivity());
        recyRmdy.setAdapter(rmdyAdapter);
        zzsyAdapter = new ZzsyAdapter(getActivity());
        recyZzry.setAdapter(zzsyAdapter);
        jjsyAdapter = new JjsyAdapter(getActivity());
        recyJjsy.setAdapter(jjsyAdapter);


        if (userInfo!=null){
            muMaPresenter = new MuMaPresenter(new MuMaCall());
            muMaPresenter.reqeust(userInfo.getUserId(),userInfo.getSessionId(),1,10);
        }
        filmRcf.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                Toast.makeText(getContext(), "您点击了第"+(position+1)+"张", Toast.LENGTH_SHORT).show();
            }
        });

        zzsyPresenter = new ZzsyPresenter(new ZzsyCall());
        zzsyPresenter.reqeust(userInfo.getUserId(),userInfo.getSessionId(),1,10);
        JjsyPresenter jjsyPresenter = new JjsyPresenter(new JjsyCall());
        jjsyPresenter.reqeust(userInfo.getUserId(),userInfo.getSessionId(),1,10);

        rlRmdy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                startActivity(intent);
            }
        });

    }

    class MuMaCall implements DataCall<Result<List<MuMaBean>>>{

        @Override
        public void onSuccess(Result<List<MuMaBean>> data) {
            if (data.getStatus().equals("0000")){
                muMaAdapter.addAll(data.getResult());
                muMaAdapter.notifyDataSetChanged();
                rmdyAdapter.addAll(data.getResult());
                rmdyAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFail(Throwable throwable) {

        }
    }

    class ZzsyCall implements DataCall<Result<List<ZzsyBean>>>{

        @Override
        public void onSuccess(Result<List<ZzsyBean>> data) {
            if (data.getStatus().equals("0000")){
                zzsyAdapter.addAll(data.getResult());
                zzsyAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFail(Throwable throwable) {

        }
    }

  class JjsyCall implements DataCall<Result<List<JjsyBean>>>{

      @Override
      public void onSuccess(Result<List<JjsyBean>> data) {
          if (data.getStatus().equals("0000")){
              jjsyAdapter.addAll(data.getResult());
              jjsyAdapter.notifyDataSetChanged();
          }


      }

      @Override
      public void onFail(Throwable throwable) {

      }
  }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
