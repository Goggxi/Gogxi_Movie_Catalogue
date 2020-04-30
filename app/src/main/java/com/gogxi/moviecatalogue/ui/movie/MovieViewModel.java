package com.gogxi.moviecatalogue.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gogxi.moviecatalogue.data.MovieRepository;
import com.gogxi.moviecatalogue.data.source.entity.Movie;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieRepository movieRepository;

    public MovieViewModel(){
        movieRepository = new MovieRepository();
    }

    public void setDiscoverMovie(String language){
        movieRepository.setResultMovie(language);
    }

    public LiveData<List<Movie>> getDiscoverMovie(){
        return movieRepository.getResultMovie();
    }
}
