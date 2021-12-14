package com.progettoOOP.CurrencyLayer.util;

import java.util.Vector;

import org.json.simple.JSONObject;

import com.progettoOOP.CurrencyLayer.service.FileRead;

public class FilterbyMonth extends Filter{
	String month;
	public FilterbyMonth(String currency_list,String month) {
		super(currency_list);
		this.month=month;}
	public JSONObject filteredStats(String currency){
		Vector <Double> ex_rates=new Vector<Double>();
		FileRead f = new FileRead();
		data= f.getJSONfromFile();
		for(int i=0;i<data.size();i++) {
			JSONObject obj=(JSONObject)data.get(i);
			String day = (String)obj.get("Date");
			String[] values = day.split("-");
			String m = values[1];
			if(m.equals(month)) {
			
			JSONObject quote =(JSONObject)obj.get("Quotes");
			ex_rates.add((Double)quote.get("USD"+currency));
		}}
		Stats stats = new Stats(ex_rates);
		return stats.JSONStats(currency);
		}

}
