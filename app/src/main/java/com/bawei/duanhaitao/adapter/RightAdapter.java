package com.bawei.duanhaitao.adapter;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:10:38
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.duanhaitao.R;
import com.bawei.duanhaitao.enity.RightBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder> {

    private List<RightBean.DataBean> list;
    private Context context;

    public RightAdapter(List<RightBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_item_layout, parent, false);
        return new RightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getGoods_thumb())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(holder.RightImage);
        holder.RightGuo.setText(list.get(position).getGoods_english_name());
        holder.RightName.setText(list.get(position).getGoods_name());
        holder.RightPrice.setText(list.get(position).getCurrency_price()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RightViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.RightImage)
        ImageView RightImage;
        @BindView(R.id.RightGuo)
        TextView RightGuo;
        @BindView(R.id.RightName)
        TextView RightName;
        @BindView(R.id.RightPrice)
        TextView RightPrice;


        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
             ButterKnife.bind(this, itemView);
        }
    }

}
