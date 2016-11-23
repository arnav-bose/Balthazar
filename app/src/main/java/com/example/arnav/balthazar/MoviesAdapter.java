package com.example.arnav.balthazar;

import android.graphics.Movie;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Arnav on 21/11/2016.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<DatasetMovies> listMovies;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, genre, year;

        public MyViewHolder(View view){
            super(view);
            title = (TextView)view.findViewById(R.id.title);
            genre = (TextView)view.findViewById(R.id.genre);
            year = (TextView)view.findViewById(R.id.year);
        }
    }

    public MoviesAdapter(List<DatasetMovies> listDatasetMovies){
        this.listMovies = listDatasetMovies;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DatasetMovies datasetMovies = listMovies.get(position);
        holder.title.setText(datasetMovies.getTitle());
        holder.genre.setText(datasetMovies.getGenre());
        holder.year.setText(datasetMovies.getYear());
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }




}
