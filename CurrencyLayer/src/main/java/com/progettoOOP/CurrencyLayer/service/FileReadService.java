package com.progettoOOP.CurrencyLayer.service;
import org.json.simple.JSONArray;
/**
 * Interfaccia che contiene il metodo per leggere dati da file salvato in locale
 * @author Kristian Likaj
 *
 */

public interface FileReadService {
	/**
	 * metodo che legge da file i dati relativi al valore di un set di 3 valute (EUR,GBP,BTC)
	 * negli ultimi 3 anni.
	 * @return un JSONArray contente un JSONObject per ogni mese (riferito al primo giorno del mese)
	 */
	public abstract JSONArray getJSONfromFile();

}
