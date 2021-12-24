package com.progettoOOP.CurrencyLayer.util;

import java.util.Vector;

import org.json.simple.JSONObject;

import com.progettoOOP.CurrencyLayer.service.FileRead;
/**
 * Questa classe eredita da Filter, effettua il filtraggio dei dati secondo l'anno
 * scelto dall'utente.
 * @author Amerigo Aloisi
 *
 */

public class FilterbyYear extends Filter{
	int year;
	/**
	 *  Costruttore analogo a quello di Filter che chiede in più l'anno su cui filtrare
	 * @param currency_list lista di valute inserita dall'utente (solita sintassi)
	 * @param year anno inserito dall'utente, formato yyyy 
	 */
	public FilterbyYear(String currency_list,int year) {
		super(currency_list);
		this.year=year;}
	/**
	 * Questo metodo ridefinisce quello definito nella superclasse Filter, per effettuare il filtraggio
	 * per anno
	 */
	@Override	
	public JSONObject filteredStats(String currency){
		Vector <Double> ex_rates=new Vector<Double>();
		FileRead f = new FileRead();
		data= f.getJSONfromFile();
		for(int i=0;i<data.size();i++) {
			JSONObject obj=(JSONObject)data.get(i);
			String day = (String)obj.get("Date");
			String[] values = day.split("-");
			int y = Integer.parseInt(values[2]);
			if(y==year) {


				JSONObject quote =(JSONObject)obj.get("Quotes");
				ex_rates.add((Double)quote.get("USD"+currency));
			}}
		Stats stats = new Stats(ex_rates);
		return stats.JSONStats(currency);
	}

}
