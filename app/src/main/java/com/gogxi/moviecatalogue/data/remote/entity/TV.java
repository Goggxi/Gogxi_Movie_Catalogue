package com.gogxi.moviecatalogue.data.remote.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TV implements Parcelable {

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	@SerializedName("first_air_date")
	private String firstAirDate;

	@SerializedName("overview")
	private String overview;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("vote_average")
	private double voteAverage;

	private boolean favorite = false;

	public TV(int id, String name, String firstAirDate, String overview, String originalLanguage, String posterPath, String backdropPath, double voteAverage, Boolean favorite) {
		this.id = id;
		this.name = name;
		this.firstAirDate = firstAirDate;
		this.overview = overview;
		this.originalLanguage = originalLanguage;
		this.posterPath = posterPath;
		this.backdropPath = backdropPath;
		this.voteAverage = voteAverage;
		if (favorite != null){
			this.favorite = favorite;
		}
	}

	protected TV(Parcel in) {
		id = in.readInt();
		name = in.readString();
		firstAirDate = in.readString();
		overview = in.readString();
		originalLanguage = in.readString();
		posterPath = in.readString();
		backdropPath = in.readString();
		voteAverage = in.readDouble();
		favorite = in.readByte() != 0;
	}

	public static final Creator<TV> CREATOR = new Creator<TV>() {
		@Override
		public TV createFromParcel(Parcel in) {
			return new TV(in);
		}

		@Override
		public TV[] newArray(int size) {
			return new TV[size];
		}
	};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public void setFirstAirDate(String firstAirDate) {
		this.firstAirDate = firstAirDate;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
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

	public void setVoteAverage(double voteAverage) {
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
		dest.writeString(name);
		dest.writeString(firstAirDate);
		dest.writeString(overview);
		dest.writeString(originalLanguage);
		dest.writeString(posterPath);
		dest.writeString(backdropPath);
		dest.writeDouble(voteAverage);
		dest.writeByte((byte) (favorite ? 1 : 0));
	}
}