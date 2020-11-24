package com.gogxi.moviecatalogue.data;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.data.local.entity.TVEntity;
import com.gogxi.moviecatalogue.utils.Resource;

import java.util.List;

public interface DataSource {
    LiveData<Resource<List<MovieEntity>>> get_movies();

    LiveData<Resource<List<TVEntity>>> get_tvs();

    LiveData<Resource<PagedList<MovieEntity>>> get_favorite_movie();

    LiveData<Resource<PagedList<TVEntity>>> get_favorite_tv();

    void set_favorite_movie(MovieEntity movie, boolean state);

    void set_favorite_tv(TVEntity tvShow, boolean state);
}
