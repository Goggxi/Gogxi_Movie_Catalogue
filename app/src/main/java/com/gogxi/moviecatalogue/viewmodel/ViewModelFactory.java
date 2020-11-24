package com.gogxi.moviecatalogue.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.di.Injection;
import com.gogxi.moviecatalogue.ui.favorite.movie.MovieFavoriteViewModel;
import com.gogxi.moviecatalogue.ui.favorite.tv.TvFavoriteViewModel;
import com.gogxi.moviecatalogue.ui.movie.MovieViewModel;
import com.gogxi.moviecatalogue.ui.tv.TvViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    private final Repository repository;

    private ViewModelFactory(Repository repository) {
        this.repository = repository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.repository(application));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(repository);
        } else if (modelClass.isAssignableFrom(TvViewModel.class)) {
            return (T) new TvViewModel(repository);
        } else if (modelClass.isAssignableFrom(MovieFavoriteViewModel.class)) {
            return (T) new MovieFavoriteViewModel(repository);
        } else if (modelClass.isAssignableFrom(TvFavoriteViewModel.class)) {
            return (T) new TvFavoriteViewModel(repository);
        }

        throw new IllegalArgumentException("Unknown ViewModel Class: " + modelClass.getName());
    }
}
