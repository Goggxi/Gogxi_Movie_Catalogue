package com.gogxi.moviecatalogue.ui.favorite.movie;

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
import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.ui.detail.DetailActivity;
import com.gogxi.moviecatalogue.utils.Constants;

import java.util.ArrayList;
import java.util.List;

class MovieFavoriteAdapter extends RecyclerView.Adapter<MovieFavoriteAdapter.ViewHolder> {
    private List<MovieEntity> listMovie;

    public MovieFavoriteAdapter() {
        listMovie = new ArrayList<>();
    }

    void setMovie(List<MovieEntity> listMovie) {
        if (listMovie == null) return;
        this.listMovie.clear();
        this.listMovie.addAll(listMovie);
    }

    @NonNull
    @Override
    public MovieFavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieFavoriteAdapter.ViewHolder holder, int position) {
        MovieEntity movie = listMovie.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mTitle;
        final TextView mRate;
        final TextView mRelease;
        final ImageView mPoster;
        final ImageView mBackdrop;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_title_items);
            mRate = itemView.findViewById(R.id.tv_rate_items);
            mRelease = itemView.findViewById(R.id.tv_date_items);
            mPoster = itemView.findViewById(R.id.img_poster_items);
            mBackdrop = itemView.findViewById(R.id.img_backdrop_items);
        }

        void bind(MovieEntity movie) {
            mTitle.setText(movie.getTitle());
            mRate.setText(movie.getVote_average());
            mRelease.setText(movie.getRelease_date());
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_MOVIE , movie);
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(Constants.POSTER_URL + movie.getPoster_path())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(mPoster);
            Glide.with(itemView.getContext())
                    .load(Constants.BACKDROP_URL + movie.getBackdrop_path())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(mBackdrop);
        }
    }
}
