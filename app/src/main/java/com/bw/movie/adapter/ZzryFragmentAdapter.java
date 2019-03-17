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
import com.bw.movie.bean.ZzsyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1607c王晴
 * date 2019/3/17
 * Describe:
 */
public class ZzryFragmentAdapter extends RecyclerView.Adapter<ZzryFragmentAdapter.ViewHolder> {
private Context context;
private List<ZzsyBean> list;

    public ZzryFragmentAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(List<ZzsyBean> result) {
        if (result!=null){
            list.addAll(result);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.zzry_xrecy_item, null, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.rmdy_xrecy_img.setImageURI(Uri.parse(list.get(i).getImageUrl()));
        viewHolder.rmdy_xrecy_name.setText(list.get(i).getName());
        viewHolder.rmdy_xrecy_content.setText(list.get(i).getSummary());
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView rmdy_xrecy_img;
        private final TextView rmdy_xrecy_name,rmdy_xrecy_content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rmdy_xrecy_img = itemView.findViewById(R.id.zzry_xrecy_img);
            rmdy_xrecy_name = itemView.findViewById(R.id.zzry_xrecy_name);
            rmdy_xrecy_content=  itemView.findViewById(R.id.zzry_xrecy_content);

        }
    }
}
