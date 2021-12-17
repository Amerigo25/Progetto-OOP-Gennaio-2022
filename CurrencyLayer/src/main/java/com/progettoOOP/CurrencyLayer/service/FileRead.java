package com.progettoOOP.CurrencyLayer.service;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
/**
 * Classe che implementa la relativa interfaccia
 * @author Kristian Likaj
 *
 */

public class FileRead implements FileReadService{
	/**
	 * nome del file salvato in locale
	 */
	private static String file_name = "quotes.list.txt";
	/**
	 * costruttore vuoto
	 */
	public FileRead() {};
	/**
	 * metodo che copia il contenuto del file in una stringa e poi effettua
	 * il parsing della stringa in un JSONArray
	 * @return JSONArray
	 */
	@Override
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

