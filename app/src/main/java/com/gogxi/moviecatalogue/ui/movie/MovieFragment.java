package com.gogxi.moviecatalogue.ui.movie;

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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView rvMovie;
    private TextView tvNotFound;
    private ProgressBar progessMovie;

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
        progessMovie = view.findViewById(R.id.progress_movie);
        showLoading(false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            MovieViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MovieViewModel.class);
            List<Movie> movies = viewModel.getMovie();
            if (movies != null){
                MovieAdapter movieAdapter = new MovieAdapter();
                movieAdapter.setMovie(movies);
                rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
                rvMovie.setHasFixedSize(true);
                rvMovie.setAdapter(movieAdapter);
                if (movieAdapter.getItemCount() == 0){
                    tvNotFound.setVisibility(View.VISIBLE);
                }
                showLoading(true);
            }
        }
    }

    private void showLoading(boolean state) {
        if (state){
            progessMovie.setVisibility(View.GONE);
        } else {
            progessMovie.setVisibility(View.VISIBLE);
        }
    }
}
