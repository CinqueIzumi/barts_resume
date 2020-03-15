package com.example.resume.education;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resume.R;

import java.util.ArrayList;

public class EducationFragment extends Fragment {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<School> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_education, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initializing the recyclerview
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.educationRecyclerView);
        recyclerView.setHasFixedSize(true);

        // Setting the layoutmanager and itemanimator for the recyclerview
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Creating the dataset for the adapter
        data = new SchoolFactory().createSchools();

        // Creating a new adapter, and binding the adapter to the recyclerview
        adapter = new SchoolAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}
