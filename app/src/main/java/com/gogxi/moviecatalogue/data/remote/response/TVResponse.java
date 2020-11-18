package com.gogxi.moviecatalogue.data.remote.response;

import com.gogxi.moviecatalogue.data.remote.model.TV;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TVResponse {

	@SerializedName("results")
	private List<TV> results;

	public List<TV> getResults() {
		return results;
	}
}