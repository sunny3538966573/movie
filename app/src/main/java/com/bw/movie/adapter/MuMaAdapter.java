package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MuMaBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1607c王晴
 * date 2019/3/15
 * Describe:
 */
public class MuMaAdapter extends RecyclerView.Adapter<MuMaAdapter.ViewHolder> {
private Context context;
private List<MuMaBean> list;

    public MuMaAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(List<MuMaBean> result) {
        if (result!=null){
            list.addAll(result);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.muma_item, null, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.muma_img.setImageURI(Uri.parse(list.get(i).getImageUrl()));
        viewHolder.muma_name.setText(list.get(i).getName()+"    106分钟");
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView muma_img;
        private final TextView muma_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            muma_img = itemView.findViewById(R.id.muma_img);
            muma_name = itemView.findViewById(R.id.muma_name);
        }
    }
}
