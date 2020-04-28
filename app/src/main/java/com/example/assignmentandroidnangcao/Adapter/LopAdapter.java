package com.example.assignmentandroidnangcao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentandroidnangcao.Dao.CaDao;
import com.example.assignmentandroidnangcao.Dao.LopDao;
import com.example.assignmentandroidnangcao.Model.CaModel;
import com.example.assignmentandroidnangcao.Model.Lop;
import com.example.assignmentandroidnangcao.R;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;

import java.util.List;

public class LopAdapter extends RecyclerView.Adapter<LopAdapter.ViewHolder> {
Context mContext;
List<Lop> lops;

    public LopAdapter(Context mContext, List<Lop> lops) {
        this.mContext = mContext;
        this.lops = lops;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_lop, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_stt.setText(String.valueOf(position +1 ));
        holder.tv_maLop.setText(lops.get(position).getMaLop());
        holder.tv_tenLop.setText(lops.get(position).getTenLop());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
                LopDao caDao =new LopDao(mContext);
                Lop caModel =new Lop(lops.get(position).getMaLop(),lops.get(position).getTenLop());
                caModel.setId(lops.get(position).getId());
                caDao.xoaSinhVien(caModel);
                Toast.makeText(mContext,"đã xóa",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return lops.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView tv_stt, tv_maLop, tv_tenLop;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_stt = itemView.findViewById(R.id.stt_lop);
            tv_maLop = itemView.findViewById(R.id.tv_maLop);
            tv_tenLop = itemView.findViewById(R.id.tv_tenLop);
        }
    }
}
