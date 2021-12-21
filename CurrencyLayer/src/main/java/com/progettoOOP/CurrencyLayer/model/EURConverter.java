package com.progettoOOP.CurrencyLayer.model;

import org.json.simple.JSONObject;

/**
 * Questa classe modella un convertitore in Euro
 * @author Amerigo Aloisi
 * @author Kristian Likaj
 *
 */
public class EURConverter {
	private static double USDtoEUR = 0.89;
	private JSONObject obj;
	private  String currency;
	private double amount;
	/**
	 * Costruttore
	 * @param obj JSONObject ottenuto in risposta alla chiamata api
	 * @param currency valuta che si intende convertire in Euro
	 * @param amount ammontare della valuta in questione
	 */
	public EURConverter(JSONObject obj, String currency,double amount) {
		this.obj=obj;
		this.currency=currency;
		this.amount=amount;
	}
	
	/**
	 * Questo metodo preleva dal JSONObject il tasso di cambio della valuta inserita rispetto al dollaro, e poi effettua la conversione in euro
	 * @return un JSONObject contenente il risultato della conversione
	 */
	
@SuppressWarnings("unchecked")
public JSONObject EURconvert(){
	
		JSONObject rate  = (JSONObject)obj.get("Quotes");
		
    double toUSD= (Double)rate.get("USD"+currency);
   



	double result= amount/toUSD*USDtoEUR;
	JSONObject response = new JSONObject();
	response.put("input ",amount+" "+ currency);
	response.put("result",result+" EUR");
	return response;

	

	
	
}
}
