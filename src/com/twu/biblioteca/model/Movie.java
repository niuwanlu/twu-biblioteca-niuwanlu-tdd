package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Item;

/**
 * Created by wlniu on 4/18/15.
 */
public class Movie extends Item {

    private String name;
    private String year;
    private String director;
    private int rating;
    private int movieNumber;
    private static int totalNumber = 0;

    public Movie(String name, String year, String director, int rating, boolean available) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.available = available;
        this.movieNumber = (++totalNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getMovieNumber() {
        return movieNumber;
    }

    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }

    public void printInfo() {
        System.out.println("Movie number: " + getMovieNumber() + "     Movie name: " + getName() + "     Year: " + getYear()
                + "     Director: " + getDirector() + "    Rating: " + getRating());
    }

}
