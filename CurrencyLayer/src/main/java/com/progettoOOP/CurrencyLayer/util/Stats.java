package com.progettoOOP.CurrencyLayer.util;

import java.util.Vector;

import org.json.simple.JSONObject;

public class Stats {
  private Vector <Double> quotes;
  
  public Stats (Vector<Double>quotes) {
	  this.quotes=quotes;
  }
  public double media() {
	  double sum=0;
	  for(int i=0; i<quotes.size();i++)
		  sum+=quotes.get(i);
	  double media = sum/(quotes.size());
	  return media;
  }
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
  @SuppressWarnings("unchecked")
public JSONObject JSONStats(String currency) {
	JSONObject obj = new JSONObject();
	obj.put("Currency", currency);
    obj.put("Media",media());
	obj.put("Varianza",varianza());

	return obj;}
			  


  }

