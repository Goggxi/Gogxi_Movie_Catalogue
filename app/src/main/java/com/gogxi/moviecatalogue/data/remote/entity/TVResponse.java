package com.gogxi.moviecatalogue.data.remote.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TVResponse {

	@SerializedName("results")
	private List<TV> results;

	public List<TV> getResults() {
		return results;
	}
}