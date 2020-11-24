package com.gogxi.moviecatalogue.ui.favorite.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.local.entity.TVEntity;
import com.gogxi.moviecatalogue.utils.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvFavoriteViewModelTest {
    private Repository repository = mock(Repository.class);
    private TvFavoriteViewModel tvFavoriteViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        tvFavoriteViewModel = new TvFavoriteViewModel(repository);
    }

    @Test
    public void getFavoriteTV() {
        MutableLiveData<Resource<PagedList<TVEntity>>> tvShows = new MutableLiveData<>();
        PagedList<TVEntity> pagedList = mock(PagedList.class);
        tvShows.setValue(Resource.success(pagedList));

        when(repository.get_favorite_tv()).thenReturn(tvShows);
        Observer<Resource<PagedList<TVEntity>>> observer = mock(Observer.class);
        tvFavoriteViewModel.getFavoriteTv().observeForever(observer);
        verify(observer).onChanged(Resource.success(pagedList));
    }
}