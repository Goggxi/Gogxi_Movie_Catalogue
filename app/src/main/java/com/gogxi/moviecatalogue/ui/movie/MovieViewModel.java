package com.gogxi.moviecatalogue.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.remote.entity.Movie;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private Repository repository;

    public MovieViewModel(Repository repository){
        this.repository = repository;
    }

    LiveData<List<Movie>> getMovie(){
        return repository.getMovie();
    }
}
