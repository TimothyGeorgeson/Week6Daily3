package com.example.consultants.week6daily3.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.week6daily3.R;
import com.example.consultants.week6daily3.model.GeofenceRecord;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<GeofenceRecord> records;

    public RecyclerViewAdapter(List<GeofenceRecord> records) {
        this.records = records;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,
                viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        GeofenceRecord record = records.get(i);

        viewHolder.tvEnterExit.setText(record.getEnterExit());
        viewHolder.tvFenceName.setText(record.getName());
        viewHolder.tvTime.setText(" at " + record.getTime());
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEnterExit;
        TextView tvFenceName;
        TextView tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvEnterExit = itemView.findViewById(R.id.tvEnterExit);
            tvFenceName = itemView.findViewById(R.id.tvFenceName);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }
}
