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
import com.example.assignmentandroidnangcao.Dao.SinhVienDao;
import com.example.assignmentandroidnangcao.Model.CaModel;
import com.example.assignmentandroidnangcao.Model.Lop;
import com.example.assignmentandroidnangcao.Model.SinhVienModel;
import com.example.assignmentandroidnangcao.R;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;

import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.ViewHolder> {
    Context mContext;
    List<SinhVienModel> sinhVienModels;

    public SinhVienAdapter(Context mContext, List<SinhVienModel> sinhVienModels) {
        this.mContext = mContext;
        this.sinhVienModels = sinhVienModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_sinh_vien, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienAdapter.ViewHolder holder, final int position) {
        holder.tv_stt.setText(String.valueOf(position +1 ));
        holder.tv_maSv.setText(sinhVienModels.get(position).getMaSv());
        holder.tv_tenSv.setText(sinhVienModels.get(position).getTenSv());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
                SinhVienDao caDao =new SinhVienDao(mContext);
                SinhVienModel caModel =new SinhVienModel();
                caModel.setId(sinhVienModels.get(position).getId());
                caDao.xoaSinhVien(caModel);
                Toast.makeText(mContext,"đã xóa",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return sinhVienModels.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView tv_stt, tv_tenSv, tv_maSv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_stt = itemView.findViewById(R.id.stt_sv);
            tv_maSv = itemView.findViewById(R.id.tv_maSv);
            tv_tenSv = itemView.findViewById(R.id.tv_tenSv);
        }
    }
}
