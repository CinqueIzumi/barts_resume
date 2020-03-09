package com.example.resume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.resume.about.AboutFragment;
import com.example.resume.education.EducationFragment;
import com.example.resume.projects.ProjectsFragment;
import com.example.resume.skills.SkillsFragment;
import com.example.resume.work.WorkFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView botnav = findViewById(R.id.bottom_navigation);
        botnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch(item.getItemId()) {
                    case R.id.nav_about:
                        selectedFragment = new AboutFragment();
                        break;
                    case R.id.nav_education:
                        selectedFragment = new EducationFragment();
                        break;
                    case R.id.nav_projects:
                        selectedFragment = new ProjectsFragment();
                        break;
                    case R.id.nav_skills:
                        selectedFragment = new SkillsFragment();
                        break;
                    case R.id.nav_work:
                        selectedFragment = new WorkFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
    }
}
