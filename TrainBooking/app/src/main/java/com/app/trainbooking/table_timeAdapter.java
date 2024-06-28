package com.app.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class table_timeAdapter extends RecyclerView.Adapter<table_timeAdapter.viewHolder> {
    Context context;
    List<time_table>tableList;


    public table_timeAdapter(Context context, List<time_table> tableList) {
        this.context = context;
        this.tableList = tableList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        if(tableList!=null&&tableList.size()>0){
            time_table model=tableList.get(position);
            holder.id_t.setText(model.getId());
            holder.type_t.setText(model.getType());
            holder.from_t.setText(model.getFrom());
            holder.to_t.setText(model.getTo());
        }else{
            return;
        }
    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView id_t,type_t,from_t,to_t;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            id_t=itemView.findViewById(R.id.id_t);
            type_t=itemView.findViewById(R.id.type_t);
            from_t=itemView.findViewById(R.id.from_t);
            to_t=itemView.findViewById(R.id.to_t);
        }
    }
}
