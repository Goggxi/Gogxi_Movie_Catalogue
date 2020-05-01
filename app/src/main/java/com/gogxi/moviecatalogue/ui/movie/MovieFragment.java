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
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.viewmodel.ViewModelFactory;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView rvMovie;
    private TextView tvNotFound;
    private ProgressBar mProgressMovie;

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
            MovieAdapter movieAdapter = new MovieAdapter();

            viewModel.getMovie().observe(this, movies -> {
                movieAdapter.setMovie(movies);
                movieAdapter.notifyDataSetChanged();
                if (movieAdapter.getItemCount() == 0){
                    tvNotFound.setVisibility(View.VISIBLE);
                }
                showLoading(true);
            });

            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(new ScaleInAnimationAdapter(movieAdapter));

            showLoading(false);
        }
    }

    private void showLoading(boolean state) {
        if (state){
            mProgressMovie.setVisibility(View.GONE);
        } else {
            mProgressMovie.setVisibility(View.VISIBLE);
        }
    }
}
