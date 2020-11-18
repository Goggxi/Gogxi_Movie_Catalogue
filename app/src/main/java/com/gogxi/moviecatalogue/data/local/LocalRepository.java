package com.gogxi.moviecatalogue.data.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.data.local.entity.TVEntity;
import com.gogxi.moviecatalogue.data.local.room.DatabaseDao;

import java.util.List;

public class LocalRepository {
    private final DatabaseDao databaseDao;

    private LocalRepository(DatabaseDao databaseDao) {
        this.databaseDao = databaseDao;
    }

    private static LocalRepository INSTANCE;

    public static LocalRepository get_instance(DatabaseDao databaseDao) {
        if (INSTANCE == null)
            INSTANCE = new LocalRepository(databaseDao);
        return INSTANCE;
    }

    public LiveData<List<MovieEntity>> getMovies() {
        return databaseDao.get_movies();
    }

    public void insert_movies(List<MovieEntity> movieEntities) {
        databaseDao.insert_movie(movieEntities);
    }

    public DataSource.Factory<Integer, MovieEntity> get_favorite_movie() {
        return databaseDao.get_favorite_movie();
    }

    public void set_favorite_movie(MovieEntity movieEntity, boolean state) {
        movieEntity.setFavorite(state);
        databaseDao.update_movie(movieEntity);
    }

    public LiveData<List<TVEntity>> getTv() {
        return databaseDao.get_tvs();
    }

    public void insert_tv(List<TVEntity> tvEntities) {
        databaseDao.insert_tv(tvEntities);
    }

    public DataSource.Factory<Integer, TVEntity> get_favorite_tv() {
        return databaseDao.get_favorite_tv();
    }

    public void set_favorite_tv(TVEntity tvEntity, boolean state) {
        tvEntity.setFavorite(state);
        databaseDao.update_tv(tvEntity);
    }
}
