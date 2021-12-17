package com.progettoOOP.CurrencyLayer.model;
/**
 * Questa classe modella la richiesta dell'utente
 * @author Amerigo Aloisi
 * @author Kristian Likaj
 *
 */
public class Quotes {
	private String currency_list;
	private Day day;
	/**
	 * Costruttore
	 * @param currency_list lista di valute di cui si vuole ottenere 
	 * il tasso di cambio in dollari
	 * @param day giorno a cui deve far riferimento il tasso di cambio
	 */
public Quotes(String currency_list,Day day) {
	this.currency_list=currency_list;
	this.day=day;
}
/**
 * Getters and setters
 */
public String getCurrency_list() {
	return currency_list;
}
public void setCurrency_list(String currency_list) {
	this.currency_list = currency_list;
}
public Day getDay() {
	return day;
}
public void setDay(Day day) {
	this.day = day;
}	

}
