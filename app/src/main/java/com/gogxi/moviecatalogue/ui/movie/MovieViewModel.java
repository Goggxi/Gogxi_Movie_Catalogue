package com.gogxi.moviecatalogue.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.utils.Resource;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private Repository repository;
    private MutableLiveData<String> movie = new MutableLiveData<>();

    public MovieViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<List<MovieEntity>>> movies = Transformations.switchMap(movie,
            data -> repository.get_movies());

    public void setMovieAction(String action) {
        movie.setValue(action);
    }

    public void toggleMovieFavorite(MovieEntity movieEntity) {
        final boolean favorite = !movieEntity.isFavorite();
        repository.set_favorite_movie(movieEntity, favorite);
    }
}
