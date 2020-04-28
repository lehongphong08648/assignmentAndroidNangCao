package com.example.assignmentandroidnangcao.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentandroidnangcao.Model.Item;
import com.example.assignmentandroidnangcao.R;

import java.util.List;

public class AdapterBangTin extends RecyclerView.Adapter<AdapterBangTin.ViewHolder> {

    Context mContext;
    List<Item> items;

    public AdapterBangTin(Context mContext, List<Item> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_bang_tin, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvTitle.setText(items.get(position).title);
        holder.tvPubDate.setText(items.get(position).pubDate);
        holder.tvConten.setText(items.get(position).description);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(items.get(position).link));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvPubDate, tvConten;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPubDate = itemView.findViewById(R.id.tvPubDate);
            tvConten = itemView.findViewById(R.id.tvContent);
        }
    }
}
