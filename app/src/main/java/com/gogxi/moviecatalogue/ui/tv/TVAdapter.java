package com.gogxi.moviecatalogue.ui.tv;

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
import com.gogxi.moviecatalogue.data.remote.entity.TV;
import com.gogxi.moviecatalogue.ui.detail.DetailActivity;
import com.gogxi.moviecatalogue.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class TVAdapter extends RecyclerView.Adapter<TVAdapter.ViewHolder> {
    private List<TV> listTV = new ArrayList<>();

    void setTV(List<TV> listTV) {
        if (listTV == null) return;
        this.listTV.clear();
        this.listTV.addAll(listTV);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TV tv = listTV.get(position);
        holder.bind(tv);
    }

    @Override
    public int getItemCount() {
        return listTV.size();
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

        void bind(TV tv) {
            mTitle.setText(tv.getName());
            mRate.setText(String.valueOf(tv.getVoteAverage()));
            mRelease.setText(tv.getFirstAirDate());
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TV, tv);
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(Constants.POSTER_URL + tv.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(mPoster);
            Glide.with(itemView.getContext())
                    .load(Constants.BACKDROP_URL + tv.getBackdropPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(mBackdrop);
        }
    }
}
