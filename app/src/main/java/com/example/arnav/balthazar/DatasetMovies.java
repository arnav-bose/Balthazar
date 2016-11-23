package com.example.arnav.balthazar;

/**
 * Created by Arnav on 21/11/2016.
 */
public class DatasetMovies {

    private String title, genre, year;

    public DatasetMovies(String title, String genre, String year){
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }



}
