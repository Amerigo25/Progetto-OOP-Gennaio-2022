package com.progettoOOP.CurrencyLayer.service;

import org.json.simple.JSONObject;

public interface HistoricalRateService {
	public abstract JSONObject getJSON();
	public abstract JSONObject getQuotes();



}
