package com.example.converter.service;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.converter.CurrencyConfig;
import com.example.converter.models.CurrencyResponse;
import com.example.converter.models.ExchangeRateResponse;
import com.example.converter.models.HistoricalResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import ch.qos.logback.classic.Logger;
import reactor.core.publisher.Mono;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyConfig config;
	
    private final WebClient webClient;
    private final ObjectMapper objectMapper; 
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CurrencyService.class);
    
    public CurrencyService(CurrencyConfig config, ObjectMapper objectMapper) {
        this.webClient = WebClient.builder().baseUrl(config.getApiUrl()).defaultHeader("Authorization", config.getApiKey()).build();
        this.objectMapper = objectMapper;
    }
    
	public Mono<Object> getExchangeRates() {		
		return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/latest.json")
                        .build())
                .header("Authorization", "Token " + config.getApiKey())
                .retrieve()
                .bodyToMono(ExchangeRateResponse.class)
                .map(ExchangeRateResponse -> {
                    // Process the response as needed
                    Map<String, Double> s = ExchangeRateResponse.getRates();
//                    String S = ExchangeRateResponse.toString();
                    // Perform additional operations
                    return s;
                });
                          
    }
    
    
    public Mono<Object> getCurrency(){
    	return  webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/currencies.json")
                        .build())
                .header("Authorization", "Token " + config.getApiKey())
                .retrieve()
                .bodyToMono(CurrencyResponse.class)
                .map(CurrencyResponse->{
                	Map<String, String> s= CurrencyResponse.getCurrencies();
//                	String S = CurrencyResponse.toString();
                	return s;
                });
    }
	
	public Mono<Object> getHistoricalRates(String date) {
	        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/historical/" + date + ".json") 
                        .build())
                .header("Authorization", "Token " + config.getApiKey())
                .retrieve() 
                .bodyToMono(HistoricalResponse.class)
                .map(HistoricalResponse->{
                	Map<String, Double> currency = HistoricalResponse.getRates();
                	return currency;
                });
	  }

	public String getHome() {
		return "Welcome to Currency Converter backend";
	}
   
	
	
	
//  Convert and Time-series api - available in Unlimited Plan
//	public Mono<TimeSeriesResponse> getTimeseries(String app_id, String start, String end, String base, String symbols) {
//        return webClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/time-series.json")
//                        .queryParam("app_id", app_id)
//                        .queryParam("start", start)
//                        .queryParam("end", end)
//                        .queryParam("base", base)
//                        .queryParam("symbols", symbols)                   
//                        .build())
//                .retrieve()
//                .bodyToMono(TimeSeriesResponse.class);
//    }
	
//	public Mono<ConvertCurrencyResponse> convertCurrency(double amount, String from, String to, String app_id) {
//        return webClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/convert/" + amount +"/" + from + "/" + to)
//                        .queryParam("app_id", app_id)
//                        .build())
//                .retrieve()
//                .bodyToMono(ConvertCurrencyResponse.class);
//	}
	
}
