package com.progettoOOP.CurrencyLayer.service;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;


public class FileRead implements FileReadService{
	private static String file_name = "quotes.list.txt";
	public FileRead() {};
	
	 public JSONArray getJSONfromFile() {
		 JSONArray Quotes = null;
		 try {
		 FileReader reader = new FileReader(file_name);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reader);
		
		Quotes= new JSONArray();
		return Quotes=(JSONArray)obj;}
		
		 catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		 catch (IOException e) {
				e.printStackTrace();
			} 
		 catch (ParseException e) {
				e.printStackTrace();
			}
		 return Quotes;
			
	}
}

