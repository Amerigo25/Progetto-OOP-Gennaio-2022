package com.progettoOOP.CurrencyLayer.model;
/**
 * Questa classe modella l'oggetto Day,che rappresenta una data generica
 * @author Amerigo Aloisi
 * @author Kristian Likaj
 *
 */
public class Day {
	private int year;
	private String month;
	private String day;
	/**
	 * Costruttore
	 * @param year anno di riferimento, formato yyyy
	 * @param month mese di riferimento,formato mm (a questo è dovuto il tipo String)
	 * @param day giorno di riferimento,formato dd (a questo è dovuto il tipo String)
	 */
	public Day(int year,String month,String day) {
		this.year=year;
		this.month=month;
		this.day=day;
		
	}
	/**
	 * Getters and setters
	 */
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * Metodo che restituisce una stringa contenente 
	 * la data nel formato richiesto dall'api(yyyy-mm-dd)
	 */
	@Override
	public String toString() {
		return this.day + "-"+this.month+"-"+this.year;
	}
	
}
