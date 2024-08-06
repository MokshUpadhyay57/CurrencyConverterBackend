package com.example.converter.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoricalResponse {

	    private long timestamp;
	    private String base;
	    private Map<String, Double> rates;

	    // Getters and Setters
	    public long getTimestamp() {
	        return timestamp;
	    }

	    @JsonProperty("timestamp")
	    public void setTimestamp(long timestamp) {
	        this.timestamp = timestamp;
	    }

	    public String getBase() {
	        return base;
	    }

	    @JsonProperty("base")
	    public void setBase(String base) {
	        this.base = base;
	    }

	    public Map<String, Double> getRates() {
	        return rates;
	    }

	    @JsonProperty("rates")
	    public void setRates(Map<String, Double> rates) {
	        this.rates = rates;
	    }
}
