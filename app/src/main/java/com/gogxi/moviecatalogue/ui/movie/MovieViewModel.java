package com.gogxi.moviecatalogue.ui.movie;

import androidx.lifecycle.ViewModel;

import com.gogxi.moviecatalogue.data.Movie;
import com.gogxi.moviecatalogue.utils.DataDummy;

import java.util.List;

public class MovieViewModel extends ViewModel {

    public List<Movie> getMovie() {
        return DataDummy.generateDummyMovie();
    }
}
