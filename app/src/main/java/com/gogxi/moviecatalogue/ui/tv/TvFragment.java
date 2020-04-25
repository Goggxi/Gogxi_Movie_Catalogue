package com.gogxi.moviecatalogue.ui.tv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.data.Movie;
import com.gogxi.moviecatalogue.data.TV;
import com.gogxi.moviecatalogue.ui.movie.MovieAdapter;
import com.gogxi.moviecatalogue.ui.movie.MovieViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {
    private RecyclerView rvTV;
    private TextView tvNotFound;
    private ProgressBar progessTV;

    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTV = view.findViewById(R.id.rv_tv);
        tvNotFound = view.findViewById(R.id.tv_not_tv);
        progessTV = view.findViewById(R.id.progress_tv);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            TvViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TvViewModel.class);
            List<TV> tv = viewModel.getTV();

            TVAdapter tvAdapter = new TVAdapter();
            tvAdapter.setTV(tv);

            rvTV.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTV.setHasFixedSize(true);
            rvTV.setAdapter(tvAdapter);
        }
    }
}
