package com.gogxi.moviecatalogue.ui.favorite.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.utils.Resource;

public class MovieFavoriteViewModel extends ViewModel {
    private Repository repository;

    public MovieFavoriteViewModel(Repository repository) {
        this.repository = repository;
    }

    LiveData<Resource<PagedList<MovieEntity>>> getFavoriteMovie() {
        return repository.get_favorite_movie();
    }

    void setFavoriteMovie(MovieEntity movieEntity) {
        final boolean state = !movieEntity.isFavorite();
        repository.set_favorite_movie(movieEntity, state);
    }
}
