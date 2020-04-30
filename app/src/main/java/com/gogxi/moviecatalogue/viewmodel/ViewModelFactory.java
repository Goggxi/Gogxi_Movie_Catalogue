package com.gogxi.moviecatalogue.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gogxi.moviecatalogue.ui.movie.MovieViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    public static ViewModelFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory();
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieViewModel();
        }
//        else if (modelClass.isAssignableFrom(TvShowsViewModel.class)) {
//            //noinspection unchecked
//            return (T) new TvShowsViewModel(new TvShowsRepository());
//        }
        throw new IllegalArgumentException("Unknown ViewModel Class: " + modelClass.getName());
    }
}
