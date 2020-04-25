package com.gogxi.moviecatalogue.data;

public class Movie {

//	@SerializedName("id")
	private int id;
//	@SerializedName("title")
	private String title;
//	@SerializedName("overview")
	private String overview;
//	@SerializedName("release_date")
	private String releaseDate;
//	@SerializedName("original_language")
	private String originalLanguage;
//	@SerializedName("genre_ids")
	private String posterPath;
//	@SerializedName("backdrop_path")
	private String backdropPath;
//	@SerializedName("vote_average")
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
}