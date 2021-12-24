package com.progettoOOP.CurrencyLayer.util;
import com.progettoOOP.CurrencyLayer.service.FileRead;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Vector;
/**
 * Superclasse che definisce i metodi generici del filtro, ottiene i dati sottoforma di JSONArray dalla classe FileRead
 * e costruisce poi i vettori di valori double da dare in ingresso alla classe Stats
 * @author Amerigo Aloisi
 *
 */


public class Filter {
	private String[] currencies;
	/**
	 * Costruttore che prende in ingresso la lista di valute e la splitta in un array di stringhe con un elemento pe ogni valuta
	 * @param currency_list lista di valute inserita dall'utente (solita sintassi)
	 */
	public Filter(String currency_list) {
		this.currencies=currency_list.split(",");
	}
	/**
	 * con il modificatore protected anche le classi che ereditano possono accedere a questa variabile
	 */
	protected  JSONArray data;
	/**
	 * Metodo che prende in ingresso il nome di una valuta, costruisce un vettore double contenente tutti i tassi di cambio di quella valuta
	 * che sono nel file (senza filtri), in seguito da il vettore in ingresso al costruttore della classe stats.
	 * Quest'ultima  ha un metodo per  calcolare le statistiche.
	 * @param currency la singola valuta
	 * @return un JSONObject  contenente le statistiche della singola valuta.
	 */


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

	/**
	 * Metodo che itera i passaggi del metodo precedente per ogni valuta dell'array currencies
	 * @return un JSONArray contenente un JSONObject come quello di cui sopra, per ogni valuta dell'array in ingresso
	 */
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

