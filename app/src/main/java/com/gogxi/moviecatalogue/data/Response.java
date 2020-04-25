package com.gogxi.moviecatalogue.data;

import java.util.List;

public class Response {

//	@SerializedName("results_movie")
	private List<Movie> resultsMovie;
//	@SerializedName("results_tv")
	private List<TV> resultsTv;

	public void setResultsMovie(List<Movie> resultsMovie){
		this.resultsMovie = resultsMovie;
	}

	public List<Movie> getResultsMovie(){
		return resultsMovie;
	}

	public void setResultsTv(List<TV> resultsTv) {
		this.resultsTv = resultsTv;
	}

	public List<TV> getResultsTv() {
		return resultsTv;
	}
}