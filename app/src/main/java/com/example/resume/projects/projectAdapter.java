package com.example.resume.projects;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.resume.R;
import java.util.ArrayList;

public class projectAdapter extends RecyclerView.Adapter<projectAdapter.MyViewHolder> {

    private ArrayList<ProjectModel> dataset;
    private Context mContext;

    /**
     * The constructor for the adapter, which helps generate the list of projects
     * @param data a dataset consisting out of all the projects
     * @param context the given context
     */
    public projectAdapter(ArrayList<ProjectModel> data, Context context) {
        this.dataset = data;
        this.mContext = context;
    }

    /**
     * The method which helps inflate the view
     * @param parent the parent of the viewholder
     * @param viewType the viewtype of the viewholder
     * @return returns a viewholer
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout_project, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    /**
     * This method helps with displaying the correct items at the corrent index
     * @param holder the current item
     * @param listPosition the index of the current item in the recyclerview
     */
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        // Initializing the neccessary textviews
        TextView projectName = holder.projectName;
        TextView clientName = holder.clientName;
        TextView projectSummary = holder.projectSummary;

        // Getting the image for the item that has been clicked on
        int imageRes = dataset.get(listPosition).getImageRes();

        // Setting the textviews to display the values that belong to the item that has been clicked on
        projectName.setText(dataset.get(listPosition).getProjectName());
        clientName.setText(dataset.get(listPosition).getClientName());
        projectSummary.setText(dataset.get(listPosition).getProjectSummary());

        // Loading in the picture of the item that has been clicked on using Glide
        Glide.with(mContext).load(imageRes).into(holder.projectImage);
    }

    /**
     * This method helps with managing the list of items, and is essential for the usage of index
     * @return the size of the list of items
     */
    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView projectName, clientName, projectSummary;
        ImageView projectImage;

        /**
         * The constructor for the viewholder
         * @param itemView the current view which can be used to find specific elements
         */
        public MyViewHolder(View itemView) {
            super(itemView);

            // Initializing the Text/Imageviews in the current view, which can be edited later
            this.projectName = (TextView) itemView.findViewById(R.id.projectTitle);
            this.clientName = (TextView) itemView.findViewById(R.id.projectClient);
            this.projectSummary = (TextView) itemView.findViewById(R.id.projectSummary);
            this.projectImage = (ImageView) itemView.findViewById(R.id.projectImage);

            // Setting the onClickListener, which will decide on what to do when an item gets clicked
            itemView.setOnClickListener(this);
        }

        /**
         * A method which decides on what to do when an item gets clicked
         * @param v the current view
         */
        @Override
        public void onClick(View v) {

            // Initializing the project which has been clicked
            ProjectModel currentProject = dataset.get(getAdapterPosition());

            // Creating the activity from which the fragmentmanager can be taken
            AppCompatActivity activity = (AppCompatActivity) itemView.getContext();

            // Creating a new fragment, and using parcelable to pass the current item to the new fragment
            ProjectsDetailedFragment detailedFragment = new ProjectsDetailedFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("Project", currentProject);
            detailedFragment.setArguments(bundle);

            // Changing the fragment which is displayed
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, detailedFragment).commit();
        }
    }
}
