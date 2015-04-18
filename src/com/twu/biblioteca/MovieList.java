package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by wlniu on 4/18/15.
 */
public class MovieList {

    private ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void initMovieList() {
        movies = new ArrayList<Movie>();
        Movie movie1 = new Movie("Gone with the Wind", "1939", "Victor Fleming", 8);
        movies.add(movie1);
        Movie movie2 = new Movie("Roman Holiday", "1953", "William Wyler", 9);
        movies.add(movie2);
    }

    public void showMovieList() {
        System.out.println("======================== Movie List ========================");
        for (Movie movie : movies) {
            System.out.println("Movie name: " + movie.getName() + "     Year: " + movie.getYear()
                    + "     Director: " + movie.getDirector() + "    Rating: " + movie.getRating() );
        }
        System.out.println("===========================================================");
    }
}
