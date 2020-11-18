package com.gogxi.moviecatalogue.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.utils.FakeDataDummy;
import com.gogxi.moviecatalogue.utils.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieViewModelTest {
    private MovieViewModel movieViewModel;
    private Repository repository = mock(Repository.class);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        movieViewModel = new MovieViewModel(repository);
    }

    @Test
    public void getMovies() {
        Resource<List<MovieEntity>> resource = Resource.success(FakeDataDummy.generateDummyRemoteMovie());
        MutableLiveData<Resource<List<MovieEntity>>> movies = new MutableLiveData<>();
        movies.setValue(resource);

        when(repository.get_movies()).thenReturn(movies);
        Observer<Resource<List<MovieEntity>>> observer = mock(Observer.class);
        movieViewModel.setMovieAction("load");
        movieViewModel.movies.observeForever(observer);
        verify(observer).onChanged(resource);
    }
}