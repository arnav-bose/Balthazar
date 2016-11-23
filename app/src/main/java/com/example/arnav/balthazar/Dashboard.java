package com.example.arnav.balthazar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    private List<DatasetMovies> listDataSetMovies = new ArrayList<>();
    private RecyclerView recyclerViewDashboard;
    private MoviesAdapter moviesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerViewDashboard = (RecyclerView) findViewById(R.id.recycler_view_dashboard);
        moviesAdapter = new MoviesAdapter(listDataSetMovies);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewDashboard.setLayoutManager(layoutManager);
        recyclerViewDashboard.setItemAnimator(new DefaultItemAnimator());
        recyclerViewDashboard.setAdapter(moviesAdapter);

        getMovieData();

        recyclerViewDashboard.addOnItemTouchListener(new RecyclerViewItemClickListener(getApplicationContext(), new RecyclerViewItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intentInnerDashboard = new Intent(Dashboard.this, InnerDashboard.class);
                    intentInnerDashboard.putExtra("itemPosition", position + 1);
                    startActivity(intentInnerDashboard);
                }})
        );

    }

    private void getMovieData() {
        String title = "Dashboard";
        int entry;
        String yash = "motu";

        for(entry = 1; entry <= 10; entry++){
            DatasetMovies datasetMovies = new DatasetMovies(title, String.valueOf(entry), yash);
            listDataSetMovies.add(datasetMovies);
        }

        /*DatasetMovies movie = new DatasetMovies("Dashboard", "Action & Adventure", "2015");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Inside Out", "Animation, Kids & Family", "2015");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Shaun the Sheep", "Animation", "2015");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("The Martian", "Science Fiction & Fantasy", "2015");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Mission: Impossible Rogue Nation", "Action", "2015");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Up", "Animation", "2009");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Star Trek", "Science Fiction", "2009");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("The LEGO Movie", "Animation", "2014");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Iron Man", "Action & Adventure", "2008");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Aliens", "Science Fiction", "1986");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Chicken Run", "Animation", "2000");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Back to the Future", "Science Fiction", "1985");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Raiders of the Lost Ark", "Action & Adventure", "1981");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Goldfinger", "Action & Adventure", "1965");
        listDataSetMovies.add(movie);

        movie = new DatasetMovies("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        listDataSetMovies.add(movie);*/

        moviesAdapter.notifyDataSetChanged();
    }
}
