package com.gogxi.moviecatalogue.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.gogxi.moviecatalogue.data.remote.RemoteDataSource;
import com.gogxi.moviecatalogue.data.remote.model.Movie;
import com.gogxi.moviecatalogue.data.remote.model.TV;
import com.gogxi.moviecatalogue.utils.DataDummy;
import com.gogxi.moviecatalogue.utils.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteDataSource remote = mock(RemoteDataSource.class);
    private FakeRepository repository = new FakeRepository(remote);

    private List<Movie> movie = DataDummy.generateDummyMovie();
    private List<TV> tv = DataDummy.generateDummyTV();

    @Test
    public void getMovie() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMovieCallback) invocation.getArguments()[0]).onMovieReceived(movie);
            return null;
        }).when(remote).getMovie(any(RemoteDataSource.LoadMovieCallback.class));
        List<Movie> movieEntities = LiveDataTestUtil.getValue(repository.getMovie());
        verify(remote).getMovie(any(RemoteDataSource.LoadMovieCallback.class));

        assertNotNull(movieEntities);
        assertEquals(movie.size(), movieEntities.size());
    }

    @Test
    public void getTv() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadTvCallback) invocation.getArguments()[0]).onTvReceived(tv);
            return null;
        }).when(remote).getTv(any(RemoteDataSource.LoadTvCallback.class));
        List<TV> tvEntities = LiveDataTestUtil.getValue(repository.getTv());
        verify(remote).getTv(any(RemoteDataSource.LoadTvCallback.class));

        assertNotNull(tvEntities);
        assertEquals(movie.size(), tvEntities.size());
    }
}