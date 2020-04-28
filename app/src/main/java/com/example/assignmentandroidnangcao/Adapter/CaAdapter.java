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
import com.example.assignmentandroidnangcao.Model.CaModel;
import com.example.assignmentandroidnangcao.R;
import com.example.assignmentandroidnangcao.database.DatabaseHelper;

import java.util.List;

public class CaAdapter extends RecyclerView.Adapter<CaAdapter.ViewHolder> {
    DatabaseHelper databaseHelper;
    Context context;
    List<CaModel> caModels;

    public CaAdapter(Context context, List<CaModel> caModels) {
        this.context = context;
        this.caModels = caModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_ca,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.tv_stt_ca.setText(String.valueOf(position + 1));
            holder.tv_tenLop_ca.setText(String.valueOf(caModels.get(position).getIdLop()));
        holder.tv_tenSv_ca.setText(String.valueOf(caModels.get(position).getIdSv()));
        holder.tv_ca.setText(caModels.get(position).getCa());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(context);
                CaDao caDao =new CaDao(context);
                CaModel caModel =new CaModel();
                caModel.setIdCa(caModels.get(position).getIdCa());
                caDao.xoaCa(caModel);
                Toast.makeText(context,"đã xóa",Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return caModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_stt_ca, tv_tenLop_ca, tv_tenSv_ca, tv_ca;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_stt_ca = itemView.findViewById(R.id.stt_caca);
            tv_tenLop_ca = itemView.findViewById(R.id.tv_maLop_caca);
            tv_tenSv_ca = itemView.findViewById(R.id.tv_tenSv_caca);
            tv_ca = itemView.findViewById(R.id.tv_tenCa_ca);
        }
    }
}
