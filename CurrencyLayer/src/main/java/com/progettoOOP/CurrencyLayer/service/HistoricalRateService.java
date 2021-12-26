package com.progettoOOP.CurrencyLayer.service;

import org.json.simple.JSONObject;

import exceptions.WrongRequestException;
/**
 * Interfaccia che contiene i metodi per la chiamata API
 * @author Amerigo Aloisi
 * @author Kristian Likaj
 */

public interface HistoricalRateService {
	/**
	 * metodo che salva in un JSONObject la risposta dell'api
	 * @return JSONObject con tutta la risposta
	 */
	public abstract JSONObject getJSON();
	/**
	 * metodo che preleva dalla risposta i campi di interesse e li
	 * salva in un altro JSONObject specificando la data di riferimento
	 * @return JSONObject con i campi di interesse
	 */
	public abstract JSONObject getQuotes() throws WrongRequestException;



}
