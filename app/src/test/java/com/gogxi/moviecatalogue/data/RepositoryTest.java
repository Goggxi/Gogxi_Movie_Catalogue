package com.gogxi.moviecatalogue.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.gogxi.moviecatalogue.data.local.LocalRepository;
import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.data.local.entity.TVEntity;
import com.gogxi.moviecatalogue.data.remote.RemoteRepository;
import com.gogxi.moviecatalogue.utils.FakeDataDummy;
import com.gogxi.moviecatalogue.utils.InstantAppExecutors;
import com.gogxi.moviecatalogue.utils.LiveDataTestUtil;
import com.gogxi.moviecatalogue.utils.PagedListUtil;
import com.gogxi.moviecatalogue.utils.Resource;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private LocalRepository localRepository = mock(LocalRepository.class);
    private RemoteRepository remoteRepository = mock(RemoteRepository.class);
    private InstantAppExecutors instantAppExecutors = mock(InstantAppExecutors.class);
    private FakeRepository fakeRepository = new FakeRepository(localRepository, remoteRepository, instantAppExecutors);

    private List<MovieEntity> movies = FakeDataDummy.generateDummyRemoteMovie();
    private List<TVEntity> tvs = FakeDataDummy.generateDummyRemoteTv();

    @Test
    public void getMovies() {
        MutableLiveData<List<MovieEntity>> dummyMovies = new MutableLiveData<>();
        dummyMovies.setValue(FakeDataDummy.generateDummyRemoteMovie());

        when(localRepository.getMovies()).thenReturn(dummyMovies);
        Resource<List<MovieEntity>> result = LiveDataTestUtil.getValue(fakeRepository.get_movies());

        verify(localRepository).getMovies();
        TestCase.assertNotNull(result.data);
        assertEquals(movies.size(), result.data.size());
    }

    @Test
    public void getTvs() {
        MutableLiveData<List<TVEntity>> dummyTvShow = new MutableLiveData<>();
        dummyTvShow.setValue(FakeDataDummy.generateDummyRemoteTv());

        when(localRepository.getTv()).thenReturn(dummyTvShow);
        Resource<List<TVEntity>> result = LiveDataTestUtil.getValue(fakeRepository.get_tvs());

        verify(localRepository).getTv();
        TestCase.assertNotNull(result.data);
        assertEquals(tvs.size(), result.data.size());
    }

    @Test
    public void getFavoriteMovies() {
        androidx.paging.DataSource.Factory<Integer, MovieEntity> dataSourceFactory = mock(androidx.paging.DataSource.Factory.class);

        when(localRepository.get_favorite_movie()).thenReturn(dataSourceFactory);
        fakeRepository.get_favorite_movie();
        Resource<PagedList<MovieEntity>> resultFavorite = Resource.success(PagedListUtil.mockPagedList(movies));

        verify(localRepository).get_favorite_movie();
        TestCase.assertNotNull(resultFavorite.data);
        assertEquals(movies.size(), resultFavorite.data.size());

    }

    @Test
    public void getFavoriteTvs() {
        androidx.paging.DataSource.Factory<Integer, TVEntity> dataSourceFactory = mock(DataSource.Factory.class);

        when(localRepository.get_favorite_tv()).thenReturn(dataSourceFactory);
        fakeRepository.get_favorite_tv();
        Resource<PagedList<TVEntity>> resultFavorite = Resource.success(PagedListUtil.mockPagedList(tvs));

        verify(localRepository).get_favorite_tv();
        TestCase.assertNotNull(resultFavorite.data);
        assertEquals(tvs.size(), resultFavorite.data.size());
    }
}