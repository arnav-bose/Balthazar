package com.example.arnav.balthazar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InnerDashboard extends AppCompatActivity {

    int position;
    private RecyclerView recyclerViewInnerDashboard;
    private List<DatasetMovies> listInnerDashboard = new ArrayList<>();
    private MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_dashboard);

        Bundle bundleInnerDashboard = getIntent().getExtras();
        if (bundleInnerDashboard == null)
            position = 1;
        else
            position = bundleInnerDashboard.getInt("itemPosition", 1);

        getSupportActionBar().setTitle("InnerDashboard");

        recyclerViewInnerDashboard = (RecyclerView)findViewById(R.id.recycler_view_inner_dashboard);
        moviesAdapter = new MoviesAdapter(listInnerDashboard);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewInnerDashboard.setLayoutManager(layoutManager);
        recyclerViewInnerDashboard.setItemAnimator(new DefaultItemAnimator());
        recyclerViewInnerDashboard.setAdapter(moviesAdapter);

        populateListInnerDashboard();
    }

    private void populateListInnerDashboard() {
        String title = "Inner Dashboard";
        int mainEntry = position;
        int entry;
        for(entry = 1; entry <= 10; entry++){
            DatasetMovies datasetMovies = new DatasetMovies(title, String.valueOf(mainEntry), String.valueOf(entry));
            listInnerDashboard.add(datasetMovies);
        }
    }
}
