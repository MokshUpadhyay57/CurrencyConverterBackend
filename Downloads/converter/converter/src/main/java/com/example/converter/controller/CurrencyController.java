package com.example.converter.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.converter.service.CurrencyService;

import reactor.core.publisher.Mono;

@RestController
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }
    
    
    @GetMapping("/")
    public String getHome() {
    	return currencyService.getHome();
    }
    

    @GetMapping("/exchange-rates")
    public Mono<Object> getExchangeRates() {
    	return currencyService.getExchangeRates();
    }
    
    @GetMapping("/currencies")
    public Mono<Object> getCurrencies(){
    	return currencyService.getCurrency();
    }
    
    @GetMapping("/historical/{date}")
    public Mono<Object> getHistoricalRates(@PathVariable String date) {
    	return currencyService.getHistoricalRates(date);
    }
    
    
    
    
//    @GetMapping("/timeseries")
//    public Mono<TimeSeriesResponse> getTimeseries(@PathParam("app_id") String app_id,
//    		@PathParam("start") String start,
//    		@PathParam("end") String end,
//    		@PathParam("base") String base,
//    		@PathParam("symbols") String symbols){
//        return currencyService.getTimeseries(app_id, start, end, base, symbols);
//    }
    
//    @GetMapping("/convert/{amount}/{from}/{to}")
//    public Mono<ConvertCurrencyResponse> convertCurrency(@PathVariable double amount,
//    									@PathVariable String from,
//    									@PathVariable String to,
//    									@RequestParam String app_id) {
//    	return currencyService.convertCurrency(amount, from, to, app_id);  
//    }
    

}
