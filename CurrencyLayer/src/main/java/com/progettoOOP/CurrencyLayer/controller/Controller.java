package com.progettoOOP.CurrencyLayer.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.progettoOOP.CurrencyLayer.service.HistoricalRate;

import com.progettoOOP.CurrencyLayer.model.Day;
import com.progettoOOP.CurrencyLayer.model.EURConverter;
import com.progettoOOP.CurrencyLayer.model.Quotes;
import com.progettoOOP.CurrencyLayer.util.Filter;
import com.progettoOOP.CurrencyLayer.util.FilterbyMonth;
import com.progettoOOP.CurrencyLayer.util.FilterbyYear;

import org.springframework.http.HttpStatus;
@RestController

public class Controller {
	@GetMapping("/exchange")

	public ResponseEntity<Object> getExchangeRates(
			@RequestParam (name= "currency_list", defaultValue = "BTC,EUR,GBP") String currency_list,
			@RequestParam (name = "year", defaultValue = "2021") int year, 
			@RequestParam (name = "month", defaultValue = "01") String month,
			@RequestParam (name = "day", defaultValue = "01") String day)
			  {
HistoricalRate h = new HistoricalRate(new Quotes(currency_list,new Day(year,month,day)));
	
return new ResponseEntity<> ((h.getQuotes()),HttpStatus.OK);
}
	
	@GetMapping ("/stats")
	
	public ResponseEntity<Object> getStats(
			@RequestParam (name="currency_list",defaultValue="BTC,EUR,GBP")String currency_list){
		Filter f = new Filter(currency_list);
		
	return new ResponseEntity<>(f.iterateFiltStats(),HttpStatus.OK);}
	@GetMapping("/stats/year")
	public ResponseEntity<Object> getStats(
			@RequestParam (name="currency_list",defaultValue="BTC,EUR,GBP")String currency_list,
			@RequestParam(name="year",defaultValue="2021")int year){
		FilterbyYear f = new FilterbyYear(currency_list,year);
		
	return new ResponseEntity<>(f.iterateFiltStats(),HttpStatus.OK);}
	@GetMapping("/stats/month")
	public ResponseEntity<Object> getStats(
			@RequestParam (name="currency_list",defaultValue="BTC,EUR,GBP")String currency_list,
			@RequestParam(name="month",defaultValue="01")String month){
		FilterbyMonth f = new FilterbyMonth(currency_list,month);
		
	return new ResponseEntity<>(f.iterateFiltStats(),HttpStatus.OK);}
	
	
	
	@GetMapping("/convert")
	public ResponseEntity<Object> convert(
			@RequestParam (name="currency",defaultValue="GBP")String currency,
			@RequestParam (name="amount",defaultValue="1.0") double amount,
			@RequestParam (name = "year", defaultValue = "2021") int year, 
			@RequestParam (name = "month", defaultValue = "01") String month,
			@RequestParam (name = "day", defaultValue = "01") String day)
			{
		HistoricalRate h = new HistoricalRate(new Quotes(currency,new Day(year,month,day)));
		EURConverter converter = new EURConverter(h.getQuotes(),currency,amount);

	return new ResponseEntity<>(converter.EURconvert(),HttpStatus.OK);}
	
	
	}








