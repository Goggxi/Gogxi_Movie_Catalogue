package com.gogxi.moviecatalogue.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.data.Movie;
import com.gogxi.moviecatalogue.data.TV;
import com.gogxi.moviecatalogue.utils.DataDummy;

public class DetailActivity extends AppCompatActivity {
    private static final String BASE_POSTER_URL = "https://image.tmdb.org/t/p/w185";
    private static final String BASE_BACKDROP_URL = "https://image.tmdb.org/t/p/w780";
    public static final int EXTRA_MOVIE = 0;
    public static final int EXTRA_TV = 0;
    private TextView
            mTitle,
            mRelease,
            mRate,
            mLanguage,
            mStoryline;
    private ImageView
            mPoster,
            mBackdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.detail);
        }

        mTitle = findViewById(R.id.tv_title);
        mRelease = findViewById(R.id.tv_release);
        mRate = findViewById(R.id.tv_rate);
        mLanguage = findViewById(R.id.tv_language);
        mStoryline = findViewById(R.id.tv_storyline);
        mPoster = findViewById(R.id.img_poster);
        mBackdrop = findViewById(R.id.img_backdrop);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            if (extras.getInt(String.valueOf(DetailActivity.EXTRA_MOVIE)) != 0){
                int id = extras.getInt(String.valueOf(EXTRA_MOVIE));
                for (int i = 0; i < DataDummy.generateDummyMovie().size(); i++) {
                    Movie movie = DataDummy.generateDummyMovie().get(i);
                    if (movie.getId() == id) {
                        populateMovie(movie);
                    }
                }
            }

            if (extras.getInt(String.valueOf(DetailActivity.EXTRA_TV)) != 0){
                int idTV = extras.getInt(String.valueOf(EXTRA_TV));
                for (int i = 0; i < DataDummy.generateDummyTV().size(); i++) {
                    TV tv = DataDummy.generateDummyTV().get(i);
                    if (tv.getId() == idTV) {
                        populateTV(tv);
                    }
                }
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void populateMovie(Movie movie){
        mTitle.setText(movie.getTitle());
        mRelease.setText(movie.getReleaseDate());
        mRate.setText(String.valueOf(movie.getVoteAverage()));
        mLanguage.setText(movie.getOriginalLanguage());
        mStoryline.setText(movie.getOverview());
        Glide.with(this)
                .load(BASE_POSTER_URL + movie.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(mPoster);
        Glide.with(this)
                .load(BASE_BACKDROP_URL + movie.getBackdropPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_error).error(R.drawable.ic_error))
                .into(mBackdrop);
    }

    private void populateTV(TV tv){
        mTitle.setText(tv.getName());
        mRelease.setText(tv.getFirstAirDate());
        mRate.setText(String.valueOf(tv.getVoteAverage()));
        mLanguage.setText(tv.getOriginalLanguage());
        mStoryline.setText(tv.getOverview());
        Glide.with(this)
                .load(BASE_POSTER_URL + tv.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(mPoster);
        Glide.with(this)
                .load(BASE_BACKDROP_URL + tv.getBackdropPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_error).error(R.drawable.ic_error))
                .into(mBackdrop);
    }
}
