package com.gogxi.moviecatalogue.data.remote.response;

import com.gogxi.moviecatalogue.data.remote.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

	@SerializedName("results")
	private List<Movie> results;

	public MovieResponse(List<Movie> results) {
		this.results = results;
	}

	public List<Movie> getResults(){
		return results;
	}
}