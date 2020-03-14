package com.example.resume.projects;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.resume.MainActivity;
import com.example.resume.R;

import java.util.ArrayList;

public class projectAdapter extends RecyclerView.Adapter<projectAdapter.MyViewHolder> {

    private ArrayList<ProjectModel> dataset;
    private Context mContext;

    public projectAdapter(ArrayList<ProjectModel> data, Context context) {
        this.dataset = data;
        this.mContext = context;
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
        TextView projectSummary = holder.projectSummary;

        int imageRes = dataset.get(listPosition).getImageRes();

        projectName.setText(dataset.get(listPosition).getProjectName());
        clientName.setText(dataset.get(listPosition).getClientName());
        projectSummary.setText(dataset.get(listPosition).getProjectSummary());

        Glide.with(mContext).load(imageRes).into(holder.projectImage);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView projectName, clientName, projectSummary;
        ImageView projectImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.projectName = (TextView) itemView.findViewById(R.id.projectTitle);
            this.clientName = (TextView) itemView.findViewById(R.id.projectClient);
            this.projectSummary = (TextView) itemView.findViewById(R.id.projectSummary);
            this.projectImage = (ImageView) itemView.findViewById(R.id.projectImage);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ProjectModel currentProject = dataset.get(getAdapterPosition());

            AppCompatActivity activity = (AppCompatActivity) itemView.getContext();

            ProjectsDetailedFragment detailedFragment = new ProjectsDetailedFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("Project", currentProject);
            detailedFragment.setArguments(bundle);

            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, detailedFragment).commit();
        }
    }
}
