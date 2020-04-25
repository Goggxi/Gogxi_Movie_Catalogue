package com.gogxi.moviecatalogue.data;

public class TV {
//	@SerializedName("id")
	private int id;
//	@SerializedName("name")
	private String name;
//	@SerializedName("first_air_date")
	private String firstAirDate;
//	@SerializedName("overview")
	private String overview;
//	@SerializedName("original_language")
	private String originalLanguage;
//	@SerializedName("poster_path")
	private String posterPath;
//	@SerializedName("backdrop_path")
	private String backdropPath;
//	@SerializedName("vote_average")
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
}