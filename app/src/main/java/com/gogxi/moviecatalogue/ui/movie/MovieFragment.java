package com.gogxi.moviecatalogue.ui.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.data.source.entity.Movie;
import com.gogxi.moviecatalogue.viewmodel.ViewModelFactory;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView rvMovie;
    private TextView tvNotFound;
    private ProgressBar mProgressMovie;
    private MovieAdapter movieAdapter;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_movie);
        tvNotFound = view.findViewById(R.id.tv_not_movie);
        mProgressMovie = view.findViewById(R.id.progress_movie);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance();
            MovieViewModel viewModel = new ViewModelProvider(this, factory).get(MovieViewModel.class);

            movieAdapter = new MovieAdapter();
            viewModel.setDiscoverMovie(getString(R.string.lang));
            viewModel.getDiscoverMovie().observe(this, getMovie);
            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setAdapter(movieAdapter);

            showLoading(false);
        }
    }

    private Observer<List<Movie>> getMovie = movies -> {
        if (movies != null){
            movieAdapter.setMovie(movies);
            movieAdapter.notifyDataSetChanged();
            showLoading(true);
            if (movieAdapter.getItemCount() == 0 ){
                tvNotFound.setVisibility(View.VISIBLE);
            }
        }
    };

    private void showLoading(boolean state) {
        if (state){
            mProgressMovie.setVisibility(View.GONE);
        } else {
            mProgressMovie.setVisibility(View.VISIBLE);
        }
    }
}
