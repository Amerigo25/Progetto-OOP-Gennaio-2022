package service;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import model.Day;


public class HistoricalRate {
	private final static String url_key ="http://api.currencylayer.com/historical?access_key=610f4eb38b7dfaab07250dfcf4b19601";
	String s;
	Day d;
public HistoricalRate(String s,Day d ) {
	this.s=s;
	this.d=d;
}
	
	//metodo che ottiene il JSON sotto forma di stringa
	public String getJSON(String currency_list,Day day) {
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
		     ////JSONParser parser = new JSONParser();
		     ///obj =(JSONObject) parser.parse(pojo);
		    
		    }
		      catch(Exception e) {
		    	  e.printStackTrace();
		      }
		return pojo;
		
		
		
		}
	}      

	

	


