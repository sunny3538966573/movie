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
import com.bw.movie.bean.ZzsyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1607c王晴
 * date 2019/3/15
 * Describe:
 */
public class ZzsyAdapter extends RecyclerView.Adapter<ZzsyAdapter.ViewHolder> {
private Context context;
    private List<ZzsyBean> list;

    public ZzsyAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(List<ZzsyBean> result) {
        if(result!=null){
            list.addAll(result);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.zzsy_item, null, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.zzsy_img.setImageURI(Uri.parse(list.get(i).getImageUrl()));
        viewHolder.zzsy_name.setText(list.get(i).getName());
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView zzsy_img;
        private final TextView zzsy_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            zzsy_img = itemView.findViewById(R.id.zzsy_img);
            zzsy_name = itemView.findViewById(R.id.zzsy_name);
        }
    }
}
