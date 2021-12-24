package com.progettoOOP.CurrencyLayer.test;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.progettoOOP.CurrencyLayer.util.Filter;
/**
 * Questa classe testa il metodo di filtraggio dati e calcolo statistiche  a partire dal JSONArray prelevato dal file
 * @author Amerigo Aloisi
 *
 */
class FilterTest {
	private Filter f;
	private JSONObject obj;

	private JSONArray array;

	private double value1,value2;
	@BeforeEach
	void setUp()throws Exception{
		f=new Filter("EUR");
		array=new JSONArray();
		obj=new JSONObject();



	}
	@AfterEach
	void tearDown()throws Exception{

	}
	/**
	 * Questo metodo verifica la correttezza dei dati raccolti per il calcolo di statistiche 
	 */
	@Test
	@DisplayName("Filtraggio dati e calcolo statistiche andato a buon fine")
	void getQuotesTest() {
		value1=0.8711520277777779;
		array=f.iterateFiltStats();
		obj=(JSONObject)array.get(0);
		value2=(Double)obj.get("Media");


		assertEquals(value1,value2);




	}



}