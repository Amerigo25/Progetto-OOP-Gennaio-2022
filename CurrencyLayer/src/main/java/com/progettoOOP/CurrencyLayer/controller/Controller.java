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
/**
 * Controller che gestisce tutte le rotte disponibili
 * @author Amerigo Aloisi
 * @author Kristian Likaj
 *
 */
@RestController

public class Controller {
	/**
	 * Rotta di tipo GET che ottiene il tasso di cambio in dollari di un insieme di valute in un giorno specificato
	 * @param currency_list insieme di valute in ingresso, da inserire con i relativi codici in maiuscolo e separati da virgole (vedi defaultValue)
	 * @param year anno della data di interesse, formato yyyy
	 * @param month mese della data di interesse, formato mm
	 * @param day giorno della data di interesse, formato dd
	 * @return un JSONObject con keys "Quotes" e "Date"
	 */
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
	/**
	 * Rotta di tipo GET che calcola le statistiche sulle valute in ingresso sul periodo di default (2019,2020,2021)
	 * @param currency_list insieme di valute in ingresso
	 * @return un JSONArray contente un JSONObject per ogni valuta, contenente a sua volta nome, media e varianza della valuta
	 */
	
	@GetMapping ("/stats")
	
	public ResponseEntity<Object> getStats(
			@RequestParam (name="currency_list",defaultValue="BTC,EUR,GBP")String currency_list){
		Filter f = new Filter(currency_list);
		
	return new ResponseEntity<>(f.iterateFiltStats(),HttpStatus.OK);}
	
	/**
	 * Rotta di tipo GET che calcola le statistiche sulle valute in ingresso nell'anno scelto
	 * @param currency_list insieme di valute in ingresso
	 * @param year anno indicato dall'utente
	 * @return
	 */
	@GetMapping("/stats/year")
	public ResponseEntity<Object> getStats(
			@RequestParam (name="currency_list",defaultValue="BTC,EUR,GBP")String currency_list,
			@RequestParam(name="year",defaultValue="2021")int year){
		FilterbyYear f = new FilterbyYear(currency_list,year);
		
	return new ResponseEntity<>(f.iterateFiltStats(),HttpStatus.OK);}
	
	
	/**
	 * Rotta di tipo GET che calcola le statistiche sulle valute in ingresso nello stesso mese negli ultimi anni
	 * @param currency_list insieme di valute in ingresso
	 * @param month mese indicato dall'utene
	 * @return un JSONArray contente un JSONObject per ogni valuta, contenente a sua volta nome, media e varianza della valuta
	 */
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








