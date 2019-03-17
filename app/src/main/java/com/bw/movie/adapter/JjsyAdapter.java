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
import com.bw.movie.bean.JjsyBean;
import com.bw.movie.bean.ZzsyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1607c王晴
 * date 2019/3/15
 * Describe:
 */
public class JjsyAdapter extends RecyclerView.Adapter<JjsyAdapter.ViewHolder> {
    private Context context;
    private List<JjsyBean> list;

    public JjsyAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(List<JjsyBean> result) {
        if(result!=null){
            list.addAll(result);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.jjsy_item, null, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.jjsy_img.setImageURI(Uri.parse(list.get(i).getImageUrl()));
        viewHolder.jjsy_name.setText(list.get(i).getName());
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private final SimpleDraweeView jjsy_img;
        private final TextView jjsy_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jjsy_img = itemView.findViewById(R.id.jjsy_img);
            jjsy_name = itemView.findViewById(R.id.jjsy_name);
        }
    }
}
