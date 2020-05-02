package com.gogxi.moviecatalogue.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.remote.entity.Movie;
import com.gogxi.moviecatalogue.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieViewModelTest {
    private MovieViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Repository repository;

    @Mock
    private Observer<List<Movie>> observer;

    @Before
    public void setUp(){
        viewModel = new MovieViewModel(repository);
    }

    @Test
    public void getMovie() {
        List<Movie> dummyMovie = DataDummy.generateDummyMovie();
        MutableLiveData<List<Movie>> movieList = new MutableLiveData<>();
        movieList.setValue(dummyMovie);

        when(repository.getMovie()).thenReturn(movieList);
        List<Movie> movie = viewModel.getMovie().getValue();
        verify(repository).getMovie();

        viewModel.getMovie().observeForever(observer);
        verify(observer).onChanged(dummyMovie);

        assertNotNull(movie);
        assertEquals(10 ,movie.size());
    }
}