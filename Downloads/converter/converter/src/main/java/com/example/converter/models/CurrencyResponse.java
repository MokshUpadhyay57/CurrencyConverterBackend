package com.example.converter.models;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyResponse {

    private Map<String, String> currencies = new HashMap<>();

    @JsonAnyGetter
    public Map<String, String> getCurrencies() {
        return currencies;
    }

    @JsonAnySetter
    public void setCurrency(String code, String name) {
        this.currencies.put(code, name);
    }

    @Override
    public String toString() {
        return "currencies=" + currencies;
    }
}
