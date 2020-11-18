package com.gogxi.moviecatalogue.ui.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.remote.model.TV;
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
public class TvViewModelTest {
    private TvViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Repository repository;

    @Mock
    private Observer<List<TV>> observer;

    @Before
    public void setUp(){
        viewModel = new TvViewModel(repository);
    }

    @Test
    public void getTV() {
        List<TV> dummyTV = DataDummy.generateDummyTV();
        MutableLiveData<List<TV>> tvList = new MutableLiveData<>();
        tvList.setValue(dummyTV);

        when(repository.getTv()).thenReturn(tvList);
        List<TV> tv = viewModel.getTv().getValue();
        verify(repository).getTv();

        viewModel.getTv().observeForever(observer);
        verify(observer).onChanged(dummyTV);

        assertNotNull(tv);
        assertEquals(10 , tv.size());
    }
}