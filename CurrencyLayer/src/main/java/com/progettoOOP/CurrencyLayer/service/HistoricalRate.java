package com.progettoOOP.CurrencyLayer.service;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;


import org.json.simple.parser.ParseException;

import com.progettoOOP.CurrencyLayer.exceptions.WrongRequestException;
import com.progettoOOP.CurrencyLayer.model.Quotes;



import org.json.simple.JSONValue;
/**
 * Questa classe implementa la relativa interfaccia
 * @author Amerigo Aloisi
 * @author Kristian Likaj
 *
 */

public class HistoricalRate implements HistoricalRateService{
	protected final static String Url ="http://api.currencylayer.com/historical?access_key=";
	/**
	 * Si ricorda di riscrivere questa variabile con la propria key personale
	 * ottenibile iscrivendosi gratuitamente su currencylayer.com
	 */
	protected final static String key = "610f4eb38b7dfaab07250dfcf4b19601";
	private Quotes quotes;
	/**
	 * Costruttore che prende in ingresso un oggetto di tipo Quotes
	 * contenente a sua volta i parametri della richiesta
	 * @param quotes
	 */
	public HistoricalRate(Quotes quotes) {
		this.quotes=quotes;
	}
	/**
	 * Questo metodo stabilisce la connessione URL al server dell'API ed effettua la richiesta 
	 * con i parametri specificati dall'oggetto Quotes, copia la risposta in una stringa
	 * ed effettua poi il parsing di quest'ultima in un JSONObject
	 */
	@Override
	public JSONObject getJSON() {
		String pojo="";
		JSONObject obj=null;
		try {

			URL url = new URL(Url+key+"&currencies=" +quotes.getCurrency_list()+"&date="+
					quotes.getDay().getYear()+"-"+quotes.getDay().getMonth()+"-"+quotes.getDay().getDay());
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
			while((inputLine=in.readLine())!=null) {
				pojo+=inputLine;
			}
			in.close();

			obj = (JSONObject) JSONValue.parseWithException(pojo);
		}
		catch(ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
	/**
	 * Questo metodo richiama il metodo precedente, in seguito crea un JSONObject contenente 
	 * i valori di interesse della risposta totale dell'API (Key:"Quotes") e la data a cui fanno 
	 * riferimento (presa come parametro dall'oggetto Quotes).
	 * @throws WrongRequestException 
	 */
	@Override
	@SuppressWarnings("unchecked")

	public JSONObject getQuotes() throws WrongRequestException {
		JSONObject obj = getJSON();
		JSONObject ex_rates= new JSONObject();
		if((obj.get("quotes")!=null)) {
			ex_rates.put("Quotes",obj.get("quotes"));
			ex_rates.put("Date", quotes.getDay().toString());}
		else {
			throw new WrongRequestException("Errore: hai inserito una valuta o una data non valida");
		}

		return ex_rates;
	}




}







