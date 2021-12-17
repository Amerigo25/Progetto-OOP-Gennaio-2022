package com.progettoOOP.CurrencyLayer.util;

import java.util.Vector;

import org.json.simple.JSONObject;

/**
 * Questa classe effettua il calcolo delle statistiche 
 * @author Kristian Likaj
 *
 */
public class Stats {
  private Vector <Double> quotes;
  /**
   * Costruttore
   * @param quotes vettore di numeri in formato double che contiene le quote
   * della valuta lette da file
   */
  
  public Stats (Vector<Double>quotes) {
	  this.quotes=quotes;
  }
  
  /**
   * Metodo che calcola la media
   */
  public double media() {
	  double sum=0;
	  for(int i=0; i<quotes.size();i++)
		  sum+=quotes.get(i);
	  double media = sum/(quotes.size());
	  return media;
  }
  
  /**
   * Metodo che calcola la varianza
   */
  public double varianza() {
	  double m = media();
	  double sum = 0;
	  for(int i=0; i<quotes.size();i++)
		  sum+=(quotes.get(i)-m)*(quotes.get(i)-m);
	  double varianza =sum/quotes.size();
	  return varianza;
  }
  public double max() {
	  double max=0;
	  for(int i = 0; i<quotes.size();i++) {
		  if(max<=quotes.get(i))
			  max=quotes.get(i);
	  }
	  return max;
  }
  public double min() {
	  double min = quotes.get(0);
	  for(int i=1;i<quotes.size();i++) {
		  if(min>=quotes.get(i))
			  min=quotes.get(i);
		  }
	  return min;
  }
  
  /**
   * questo metodo restituisce le statistiche formattate in un JSONObject 
   * che indica a quale valuta sono riferite
   * @param currency valuta di riferimento
   * @return un JSONObject che sarà il valore di ritorno della funzione filteredStats
   * (vedi "Filter" in questo package)
   */
  @SuppressWarnings("unchecked")
public JSONObject JSONStats(String currency) {
	JSONObject obj = new JSONObject();
	obj.put("Currency", currency);
    obj.put("Media",media());
	obj.put("Varianza",varianza());

	return obj;}
			  


  }

