package com.gogxi.moviecatalogue.ui.movie;

import com.gogxi.moviecatalogue.data.source.entity.Movie;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {
    private MovieViewModel movieViewModel;

    @Before
    public void setUp(){
        movieViewModel = new MovieViewModel(repository);
    }

    @Test
    public void getMovie() {
        List<Movie> movies = movieViewModel.getMovie();
        assertNotNull(movies);
        assertEquals(10 ,movies.size());
    }
}