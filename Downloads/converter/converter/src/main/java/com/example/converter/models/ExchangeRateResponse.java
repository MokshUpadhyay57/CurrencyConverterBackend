package com.example.converter.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateResponse {

	    private long timestamp;
	    private String base;

	    private Map<String, Double> rates;
	    
	    public long getTimestamp() {
	    	System.out.println("TimeStamp");
			return timestamp ;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		public String getBase() {
			return base;
		}

		public void setBase(String base) {
			this.base = base;
		}

		public Map<String, Double> getRates() {
			return rates;
		}

		public void setRates(Map<String, Double> rates) {
			this.rates = rates;
		}

		@Override
		public String toString() {
			System.out.println("toString() Called");
			return "ExchangeRateResponse [timestamp=" + timestamp + ", base=" + base + ", rates=" + rates + "]";
		}

		
}
