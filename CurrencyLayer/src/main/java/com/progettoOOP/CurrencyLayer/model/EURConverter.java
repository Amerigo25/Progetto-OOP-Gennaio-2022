package com.progettoOOP.CurrencyLayer.model;

import org.json.simple.JSONObject;

import com.progettoOOP.CurrencyLayer.service.HistoricalRate;

public class EURConverter {
	private JSONObject obj;
	private  String currency;
	private double amount;
	public EURConverter(JSONObject obj, String currency,double amount) {
		this.obj=obj;
		this.currency=currency;
		this.amount=amount;
	}
	
	
	
@SuppressWarnings("unchecked")
public JSONObject EURconvert(){
	
		JSONObject rate  = (JSONObject)obj.get("Quotes");
		
    double toUSD= (Double)rate.get("USD"+currency);
   

	double toEUR=0.8;
	
	double result= amount*toUSD/toEUR;
	JSONObject response = new JSONObject();
	response.put("From",currency);
	response.put("To", "EUR");
	response.put("result",result);
	return response;

	

	
	
}
}
