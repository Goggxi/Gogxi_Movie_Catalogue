package com.gogxi.moviecatalogue.data.source.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("overview")
	private String overview;

	@SerializedName("release_date")
	private String releaseDate;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("vote_average")
	private double voteAverage;

	private boolean favorite = false;

	public Movie(int id, String title, String overview, String releaseDate, String originalLanguage, String posterPath, String backdropPath, double voteAverage, Boolean favorite) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.releaseDate = releaseDate;
		this.originalLanguage = originalLanguage;
		this.posterPath = posterPath;
		this.backdropPath = backdropPath;
		this.voteAverage = voteAverage;
		if (favorite != null){
			this.favorite = favorite;
		}
	}

	protected Movie(Parcel in) {
		id = in.readInt();
		title = in.readString();
		overview = in.readString();
		releaseDate = in.readString();
		originalLanguage = in.readString();
		posterPath = in.readString();
		backdropPath = in.readString();
		voteAverage = in.readDouble();
		favorite = in.readByte() != 0;
	}

	public static final Creator<Movie> CREATOR = new Creator<Movie>() {
		@Override
		public Movie createFromParcel(Parcel in) {
			return new Movie(in);
		}

		@Override
		public Movie[] newArray(int size) {
			return new Movie[size];
		}
	};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(int voteAverage) {
		this.voteAverage = voteAverage;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(title);
		dest.writeString(overview);
		dest.writeString(releaseDate);
		dest.writeString(originalLanguage);
		dest.writeString(posterPath);
		dest.writeString(backdropPath);
		dest.writeDouble(voteAverage);
		dest.writeByte((byte) (favorite ? 1 : 0));
	}
}