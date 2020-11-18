package com.gogxi.moviecatalogue.ui.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.viewmodel.ViewModelFactory;

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
            mProgressMovie.setVisibility(View.VISIBLE);
            MovieViewModel movieViewModel = obtainViewModel(getActivity());
            movieAdapter = new MovieAdapter(getActivity());

            movieViewModel.setMovieAction("load");
            movieViewModel.movies.observe(getViewLifecycleOwner(), movie -> {
                if (movie != null) {
                    switch (movie.status) {
                        case SUCCESS:
                            mProgressMovie.setVisibility(View.GONE);
                            movieAdapter.setMovie(movie.data);
                            movieAdapter.notifyDataSetChanged();
                            break;
                        case LOADING:
                            mProgressMovie.setVisibility(View.VISIBLE);
                            break;
                        case ERROR:
                            tvNotFound.setVisibility(View.VISIBLE);
                            mProgressMovie.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            });

            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(movieAdapter);
        }
    }

    private static MovieViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(MovieViewModel.class);
    }
}
