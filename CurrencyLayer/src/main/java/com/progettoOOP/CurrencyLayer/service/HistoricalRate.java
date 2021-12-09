package com.progettoOOP.CurrencyLayer.service;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.progettoOOP.CurrencyLayer.model.Day;

import org.json.simple.JSONValue;
public class HistoricalRate {
	private final static String url_key ="http://api.currencylayer.com/historical?access_key=610f4eb38b7dfaab07250dfcf4b19601";
	String currency_list;
	Day day;
public HistoricalRate(String currency_list,Day day) {
	this.currency_list=currency_list;
	this.day=day;
}
	
	//metodo che ottiene il JSON sotto forma di stringa
	public JSONObject getJSON() {
		String pojo="";
		JSONObject obj=null;
		try {
			
			URL url = new URL(url_key+"&currencies="+ currency_list+"&date="+
		    day.getYear()+"-"+day.getMonth()+"-"+day.getDay());
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
		      catch(Exception e) {
		    	  e.printStackTrace();
		      }
		return obj;
		
		
		
		}

}
