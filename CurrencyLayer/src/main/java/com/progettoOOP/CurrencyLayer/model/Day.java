package com.progettoOOP.CurrencyLayer.model;

public class Day {
	private int year;
	private String month;
	private String day;
	//costruttore
	public Day(int year,String month,String day) {
		this.year=year;
		this.month=month;
		this.day=day;
		
	}
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
	public String toString() {
		return this.day + "-"+this.month+"-"+this.year;
	}
	
}
