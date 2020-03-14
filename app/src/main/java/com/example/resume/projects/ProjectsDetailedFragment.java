package com.example.resume.projects;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.example.resume.R;

public class ProjectsDetailedFragment extends Fragment {
    private ProjectModel detailedProject;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Creating the view
        view = inflater.inflate(R.layout.fragment_detailed_project, container, false);

        // Getting the project, which has been passed onto this fragment from the recyclerview
        Bundle bundle = getArguments();
        if(bundle != null) {
            detailedProject = bundle.getParcelable("Project");
        }

        // Initializing the Text / Imageviews
        TextView projectName = view.findViewById(R.id.titleDetail);
        TextView projectClient = view.findViewById(R.id.clientNameDetail);
        TextView projectDesc = view.findViewById(R.id.projectDescDetail);
        ImageView projectImage = view.findViewById(R.id.projectImageDetail);

        // Setting the textviews to the values of the project
        projectName.setText(detailedProject.getProjectName());
        projectClient.setText(detailedProject.getClientName());
        projectDesc.setText(detailedProject.getProjectDesc());

        // Loading in the picture belonging to the project using Glide
        Glide.with(view.getContext()).load(detailedProject.getImageRes()).into(projectImage);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creating how the app will handle it when users try to go back
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProjectsFragment()).commit();
            }
        };

        // Adding the callback to the activity
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }
}
