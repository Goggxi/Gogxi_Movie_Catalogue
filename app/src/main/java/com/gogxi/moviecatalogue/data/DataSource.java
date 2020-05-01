package com.gogxi.moviecatalogue.data;

import androidx.lifecycle.LiveData;

import com.gogxi.moviecatalogue.data.remote.entity.Movie;
import com.gogxi.moviecatalogue.data.remote.entity.TV;

import java.util.List;

public interface DataSource {

    LiveData<List<Movie>> getMovie();

    LiveData<List<TV>> getTv();
}
