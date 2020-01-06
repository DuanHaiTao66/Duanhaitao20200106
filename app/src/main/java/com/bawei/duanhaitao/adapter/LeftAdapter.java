package com.bawei.duanhaitao.adapter;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:9:44
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.duanhaitao.MainActivity;
import com.bawei.duanhaitao.R;
import com.bawei.duanhaitao.enity.LeftBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftViewHolder> {

    private List<String> list;
    private Context context;

    public LeftAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public LeftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_item_layout, parent, false);
        return new LeftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolder holder, int position) {
        holder.LeftName.setText(list.get(position));
        holder.LeftName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = list.get(position);
                EventBus.getDefault().post(s);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class LeftViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.LeftName)
        TextView LeftName;
        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
