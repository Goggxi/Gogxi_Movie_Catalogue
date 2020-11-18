package com.gogxi.moviecatalogue.ui.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.local.entity.TVEntity;
import com.gogxi.moviecatalogue.data.remote.model.TV;
import com.gogxi.moviecatalogue.utils.DataDummy;
import com.gogxi.moviecatalogue.utils.FakeDataDummy;
import com.gogxi.moviecatalogue.utils.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TvViewModelTest {
    private TvViewModel tvViewModel;
    private Repository repository = mock(Repository.class);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        tvViewModel = new TvViewModel(repository);
    }

    @Test
    public void getTvs() {
        Resource<List<TVEntity>> resource = Resource.success(FakeDataDummy.generateDummyRemoteTv());
        MutableLiveData<Resource<List<TVEntity>>> tvs = new MutableLiveData<>();
        tvs.setValue(resource);

        when(repository.get_tvs()).thenReturn(tvs);
        Observer<Resource<List<TVEntity>>> observer = mock(Observer.class);
        tvViewModel.setTvAction("load");
        tvViewModel.tvShows.observeForever(observer);
        verify(observer).onChanged(resource);
    }
}