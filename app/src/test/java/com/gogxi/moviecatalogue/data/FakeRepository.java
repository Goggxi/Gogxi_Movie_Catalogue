package com.gogxi.moviecatalogue.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gogxi.moviecatalogue.data.remote.RemoteDataSource;
import com.gogxi.moviecatalogue.data.remote.model.Movie;
import com.gogxi.moviecatalogue.data.remote.model.TV;

import java.util.List;

public class FakeRepository implements DataSource {

    private final RemoteDataSource remoteDataSource;

    FakeRepository(@NonNull RemoteDataSource remoteDataSource){
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public LiveData<List<Movie>> getMovie() {
        final MutableLiveData<List<Movie>> movieList = new MutableLiveData<>();
        remoteDataSource.getMovie(movieList::postValue);
        return movieList;
    }

    @Override
    public LiveData<List<TV>> getTv() {
        final MutableLiveData<List<TV>> tvList = new MutableLiveData<>();
        remoteDataSource.getTv(tvList::postValue);
        return tvList;
    }
}