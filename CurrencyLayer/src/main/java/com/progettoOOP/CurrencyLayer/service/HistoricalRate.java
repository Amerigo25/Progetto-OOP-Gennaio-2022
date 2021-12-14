package com.progettoOOP.CurrencyLayer.service;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;


import org.json.simple.parser.ParseException;

import com.progettoOOP.CurrencyLayer.model.Day;
import com.progettoOOP.CurrencyLayer.model.Quotes;

import org.json.simple.JSONValue;







public class HistoricalRate implements HistoricalRateService{
	private final static String Url ="http://api.currencylayer.com/historical?access_key=";
	private final static String key = "610f4eb38b7dfaab07250dfcf4b19601";
	private Quotes quotes;
public HistoricalRate(Quotes quotes) {
this.quotes=quotes;
}
	
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

@SuppressWarnings("unchecked")
public JSONObject getQuotes() {
	JSONObject obj = getJSON();
	JSONObject ex_rates= new JSONObject();
	ex_rates.put("Quotes",obj.get("quotes"));
	ex_rates.put("Date", quotes.getDay().toString());
	return ex_rates;
	}


	
	
}


	
	
	


