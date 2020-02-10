package com.example.resume;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class projectAdapter extends RecyclerView.Adapter<projectAdapter.MyViewHolder> {

    private ArrayList<ProjectModel> dataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView projectName, clientName;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.projectName = (TextView) itemView.findViewById(R.id.projectName);
            this.clientName = (TextView) itemView.findViewById(R.id.client);
        }
    }

    public projectAdapter(ArrayList<ProjectModel> data) {
        this.dataset = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

//        view.setOnClickListener(ProjectsFragment.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        TextView projectName = holder.projectName;
        TextView clientName = holder.clientName;

        projectName.setText(dataset.get(listPosition).getProjectName());
        clientName.setText(dataset.get(listPosition).getClientName());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
