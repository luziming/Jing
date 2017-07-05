package com.jing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jing.R;

import java.util.List;


/**
 * Created by smu on 2016/1/28.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context context;
    List<String> list;
    OnItemClickListener listener;

    public RecyclerAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public void addOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        //这里需指定parent 和后边的boolean 否则item的android:layout_width="match_parent"无效
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
        return new MyViewHolder(view, parent);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        public void onItemClick(ViewGroup group, View view, int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public MyViewHolder(View view, final ViewGroup group) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        listener.onItemClick(group, v, getAdapterPosition());
                    }
                }
            });
            tv = (TextView) view.findViewById(R.id.recycler_item_text);
        }
    }

}
