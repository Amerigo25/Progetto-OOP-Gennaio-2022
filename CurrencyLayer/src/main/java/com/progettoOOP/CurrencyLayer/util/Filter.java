package com.progettoOOP.CurrencyLayer.util;
import com.progettoOOP.CurrencyLayer.service.FileRead;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Vector;



public class Filter {
	private String[] currencies;
	public Filter(String currency_list) {
		this.currencies=currency_list.split(",");
}
	
protected JSONArray data;

	
public JSONObject filteredStats(String currency){
	Vector <Double> ex_rates=new Vector<Double>();
	FileRead f = new FileRead();
	data= f.getJSONfromFile();

		for(int i=0;i<data.size();i++) {
			JSONObject obj=(JSONObject)data.get(i);
			JSONObject quote =(JSONObject)obj.get("Quotes");
			ex_rates.add((Double)quote.get("USD"+currency));
		}
		Stats stats = new Stats(ex_rates);
		return stats.JSONStats(currency);
		}
@SuppressWarnings("unchecked")
public JSONArray iterateFiltStats(){
	JSONObject obj= new JSONObject();
	JSONArray array = new JSONArray();
	for( String currency: this.currencies) {
		obj=filteredStats(currency);
		array.add(obj);
		}
	
		return array;
		
	}
	
}

