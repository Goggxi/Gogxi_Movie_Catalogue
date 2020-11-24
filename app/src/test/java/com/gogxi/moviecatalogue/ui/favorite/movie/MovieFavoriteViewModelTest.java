package com.gogxi.moviecatalogue.ui.favorite.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.utils.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieFavoriteViewModelTest {
    private Repository repository = mock(Repository.class);
    private MovieFavoriteViewModel movieFavoriteViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        movieFavoriteViewModel = new MovieFavoriteViewModel(repository);
    }

    @Test
    public void getFavoriteMovie() {
        MutableLiveData<Resource<PagedList<MovieEntity>>> movies = new MutableLiveData<>();
        PagedList<MovieEntity> pagedList = mock(PagedList.class);
        movies.setValue(Resource.success(pagedList));

        when(repository.get_favorite_movie()).thenReturn(movies);
        Observer<Resource<PagedList<MovieEntity>>> observer = mock(Observer.class);
        movieFavoriteViewModel.getFavoriteMovie().observeForever(observer);
        verify(observer).onChanged(Resource.success(pagedList));
    }
}