package com.example.resume.education;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.resume.R;

import java.util.ArrayList;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolderSchool>{
    private ArrayList<School> dataset;

    /**
     * The constructor for the adapter, which helps generate the list of schools
     * @param data a dataset consisting out of all the schools
     */
    public SchoolAdapter(ArrayList<School> data) {
        this.dataset = data;
    }


    /**
     * The method which helps inflate the view
     * @param parent the parent of the viewholder
     * @param viewType the viewtype of the viewholder
     * @return returns a viewholer
     */
    @Override
    public SchoolAdapter.ViewHolderSchool onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout_education, parent, false);
        SchoolAdapter.ViewHolderSchool myViewHolder = new SchoolAdapter.ViewHolderSchool(view);

        return myViewHolder;
    }

    /**
     * This method helps with displaying the correct items at the current index
     * @param holder the current item
     * @param listPosition the index of the current item in the recyclerview
     */
    @Override
    public void onBindViewHolder(final ViewHolderSchool holder, final int listPosition) {

        // Initializing the neccessary textviews
        TextView txtSpec = holder.txtSpec;
        TextView txtSchool = holder.txtSchool;
        TextView txtLocation = holder.txtLocation;
        TextView txtDates = holder.txtDate;

        // Setting the textviews to display the values that belong to the corresponding item
        txtSpec.setText(dataset.get(listPosition).getSpecialization());
        txtSchool.setText(dataset.get(listPosition).getSchoolName());
        txtLocation.setText(dataset.get(listPosition).getLocation());
        txtDates.setText(dataset.get(listPosition).getDuration());
    }

    /**
     * This method helps with managing the list of items, and is essential for the usage of index
     * @return the size of the list of items
     */
    @Override
    public int getItemCount() {
        return dataset.size();
    }


    public class ViewHolderSchool extends RecyclerView.ViewHolder {
        TextView txtSpec, txtSchool, txtLocation, txtDate;

        /**
         * The constructor for the viewholder
         * @param itemView the current view which can be used to find specific elements
         */
        public ViewHolderSchool(View itemView) {
            super(itemView);

            // Initializing the textviews, which can be edited later
            txtSpec = (TextView) itemView.findViewById(R.id.education_specialization);
            txtSchool = (TextView) itemView.findViewById(R.id.education_schoolName);
            txtLocation = (TextView) itemView.findViewById(R.id.education_location);
            txtDate = (TextView) itemView.findViewById(R.id.education_date);
        }
    }
}
