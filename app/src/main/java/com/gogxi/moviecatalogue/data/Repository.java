package com.gogxi.moviecatalogue.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.gogxi.moviecatalogue.data.local.LocalRepository;
import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.data.local.entity.TVEntity;
import com.gogxi.moviecatalogue.data.remote.ApiResponse;
import com.gogxi.moviecatalogue.data.remote.RemoteRepository;
import com.gogxi.moviecatalogue.data.remote.model.Movie;
import com.gogxi.moviecatalogue.data.remote.model.TV;
import com.gogxi.moviecatalogue.utils.AppExecutors;
import com.gogxi.moviecatalogue.utils.Resource;

import java.util.ArrayList;
import java.util.List;


public class Repository implements DataSource {
    private final RemoteRepository remoteRepository;
    private final LocalRepository localRepository;
    private final AppExecutors appExecutors;
    private volatile static Repository INSTANCE = null;

    private Repository(@NonNull LocalRepository localRepository, @NonNull RemoteRepository remoteRepository, AppExecutors appExecutors) {
        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
        this.appExecutors = appExecutors;
    }

    public static Repository getInstance(LocalRepository localRepository, RemoteRepository remoteRepository, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (Repository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Repository(localRepository, remoteRepository, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<List<MovieEntity>>> get_movies() {
        return new NetworkBoundResource<List<MovieEntity>, List<Movie>>(appExecutors) {

            @Override
            protected LiveData<List<MovieEntity>> loadFromDB() {
                return localRepository.getMovies();
            }

            @Override
            protected Boolean shouldFetch(List<MovieEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<Movie>>> createCall() {
                return remoteRepository.getMovie();
            }

            @Override
            protected void saveCallResult(List<Movie> data) {
                List<MovieEntity> movieEntities = new ArrayList<>();

                for (Movie movie : data) {
                    movieEntities.add(new MovieEntity(
                            movie.getId(),
                            movie.getPosterPath(),
                            movie.getTitle(),
                            movie.getReleaseDate(),
                            movie.getOverview(),
                            movie.getOriginalLanguage(),
                            movie.getVoteAverage(),
                            movie.getBackdropPath(),
                            null));
                }
                localRepository.insert_movies(movieEntities);

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TVEntity>>> get_tvs() {
        return new NetworkBoundResource<List<TVEntity>, List<TV>>(appExecutors) {

            @Override
            protected LiveData<List<TVEntity>> loadFromDB() {
                return localRepository.getTv();
            }

            @Override
            protected Boolean shouldFetch(List<TVEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<TV>>> createCall() {
                return remoteRepository.getTv();
            }

            @Override
            protected void saveCallResult(List<TV> data) {
                List<TVEntity> tvEntities = new ArrayList<>();

                for (TV tvModel : data) {
                    tvEntities.add(new TVEntity(
                            tvModel.getId(),
                            tvModel.getPosterPath(),
                            tvModel.getName(),
                            tvModel.getFirstAirDate(),
                            tvModel.getOverview(),
                            tvModel.getOriginalLanguage(),
                            tvModel.getVoteAverage(),
                            tvModel.getBackdropPath(),
                            null));
                }
                localRepository.insert_tv(tvEntities);

            }
        }.asLiveData();
    }
    @Override
    public LiveData<Resource<PagedList<MovieEntity>>> get_favorite_movie() {
        return new NetworkBoundResource<PagedList<MovieEntity>, List<Movie>>(appExecutors) {

            @Override
            protected LiveData<PagedList<MovieEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.get_favorite_movie(), 20).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<MovieEntity> data) {
                return false;
            }


            @Override
            protected LiveData<ApiResponse<List<Movie>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<Movie> data) { }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<PagedList<TVEntity>>> get_favorite_tv() {
        return new NetworkBoundResource<PagedList<TVEntity>, List<TV>>(appExecutors) {

            @Override
            protected LiveData<PagedList<TVEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.get_favorite_tv(), 20).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<TVEntity> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<TV>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<TV> data) {}
        }.asLiveData();
    }

    @Override
    public void set_favorite_movie(MovieEntity movieEntity, boolean state) {
        Runnable runnable = () -> localRepository.set_favorite_movie(movieEntity, state);
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void set_favorite_tv(TVEntity tvEntity, boolean state) {
        Runnable runnable = () -> localRepository.set_favorite_tv(tvEntity, state);
        appExecutors.diskIO().execute(runnable);

    }
}