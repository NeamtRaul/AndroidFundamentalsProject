package com.example.talentradar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DemoViewHolder> {
    private ArrayList<String> nDataSet;
    private LayoutInflater nLayoutInflater;

    public RecyclerViewAdapter(Context context, ArrayList<String> dataset) {
        nDataSet = dataset;
        nLayoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = nLayoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new DemoViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return nDataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder holder, int position) {
        String title = nDataSet.get(position);
        holder.update(title, "Nr. jucatori " + (position+11));
    }

    public class DemoViewHolder extends RecyclerView.ViewHolder {
        private TextView nTeam;
        private TextView nPlayers;

        public DemoViewHolder(@NonNull View itemView) {
            super(itemView);
            nTeam = itemView.findViewById(R.id.myTeamName);
            nPlayers = itemView.findViewById(R.id.mySquadSize);
        }

        public void update(String title, String subtitle) {
            nTeam.setText(title);
            nPlayers.setText(subtitle);
        }
    }
}
