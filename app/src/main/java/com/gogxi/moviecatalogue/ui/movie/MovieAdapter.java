package com.gogxi.moviecatalogue.ui.movie;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.data.Movie;
import com.gogxi.moviecatalogue.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private static final String BASE_POSTER_URL = "https://image.tmdb.org/t/p/w185";
    private static final String BASE_BACKDROP_URL = "https://image.tmdb.org/t/p/w780";
    private List<Movie> listMovie = new ArrayList<>();

    void setMovie(List<Movie> listMovie) {
        if (listMovie == null) return;
        this.listMovie.clear();
        this.listMovie.addAll(listMovie);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = listMovie.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mTitle, mRate, mRelease;
        final ImageView mPoster, mBackdrop;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_title_items);
            mRate = itemView.findViewById(R.id.tv_rate_items);
            mRelease = itemView.findViewById(R.id.tv_date_items);
            mPoster = itemView.findViewById(R.id.img_poster_items);
            mBackdrop = itemView.findViewById(R.id.img_backdrop_items);
        }

        void bind(Movie movie) {
            mTitle.setText(movie.getTitle());
            mRate.setText(String.valueOf(movie.getVoteAverage()));
            mRelease.setText(movie.getReleaseDate());
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(String.valueOf(DetailActivity.EXTRA_MOVIE), movie.getId());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(BASE_POSTER_URL + movie.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(mPoster);
            Glide.with(itemView.getContext())
                    .load(BASE_BACKDROP_URL + movie.getBackdropPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_error).error(R.drawable.ic_error))
                    .into(mBackdrop);
        }
    }
}
