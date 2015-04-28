package com.twu.biblioteca;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;

/**
 * Created by wlniu on 4/18/15.
 */
public class MovieList {

    private ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public int getAmountOfMovies() {
        return movies.size();
    }

    public int getAmountOfAvailableMovies() {
        int count = 0;
        for (Movie movie : movies) {
            if (movie.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public void initMovieList() {
        movies = new ArrayList<Movie>();
        Movie movie1 = new Movie("Gone with the Wind", "1939", "Victor Fleming", 8, true);
        movies.add(movie1);
        Movie movie2 = new Movie("Roman Holiday", "1953", "William Wyler", 9, true);
        movies.add(movie2);
    }

    public void showMovieList() {
        System.out.println("======================== Movie List ========================");
        for (Movie movie : movies) {
            if (movie.isAvailable()) {
                System.out.println("Movie number: " + movie.getMovieNumber() + "     Movie name: " + movie.getName() + "     Year: " + movie.getYear()
                        + "     Director: " + movie.getDirector() + "    Rating: " + movie.getRating());
            }
        }
        System.out.println("============================================================");
    }
}
