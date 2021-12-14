package com.progettoOOP.CurrencyLayer.model;

public class Quotes {
	private String currency_list;
	private Day day;
public Quotes(String currency_list,Day day) {
	this.currency_list=currency_list;
	this.day=day;
}
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
