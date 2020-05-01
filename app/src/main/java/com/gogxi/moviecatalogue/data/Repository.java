package com.gogxi.moviecatalogue.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gogxi.moviecatalogue.data.remote.RemoteDataSource;
import com.gogxi.moviecatalogue.data.remote.entity.Movie;
import com.gogxi.moviecatalogue.data.remote.entity.TV;

import java.nio.channels.MulticastChannel;
import java.util.List;

public class Repository implements DataSource {

    private volatile static Repository INSTANCE = null;

    private RemoteDataSource remoteDataSource;

    private Repository(@NonNull RemoteDataSource remoteDataSource){
        this.remoteDataSource = remoteDataSource;
    }

    public static Repository getInstance(RemoteDataSource remoteDataSource){
        if (INSTANCE == null){
            synchronized (Repository.class){
                if (INSTANCE == null){
                    INSTANCE = new Repository(remoteDataSource);
                }
            }
        }
        return INSTANCE;
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
