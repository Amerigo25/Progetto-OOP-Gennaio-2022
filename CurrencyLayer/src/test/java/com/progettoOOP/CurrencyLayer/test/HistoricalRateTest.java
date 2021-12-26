package com.progettoOOP.CurrencyLayer.test;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.progettoOOP.CurrencyLayer.service.HistoricalRate;
import com.progettoOOP.CurrencyLayer.exceptions.WrongRequestException;
import com.progettoOOP.CurrencyLayer.model.*;
/**
 * Questa classe testa il metodo che effettua la chiamata API salvandola su un JSONObject, da cui poi  preleva  i campi di interesse
 * @author Amerigo Aloisi
 *
 */
class HistoricalRateTest {
	private HistoricalRate h;
	private JSONObject obj,quotes;


	@BeforeEach
	void setUp()throws Exception{
		h= new HistoricalRate(new Quotes("EUR,GBP",new Day(2021,"01","01")));
		obj=new JSONObject();

		quotes =new JSONObject();

	}
	@AfterEach
	void tearDown()throws Exception{

	}
	/**
	 * Questo metodo verifica la correttezza dei dati ottenuti dalla chiamata API
	 * @throws WrongRequestException 
	 */
	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Chiamata api andata a buon fine")
	void getQuotesTest() throws WrongRequestException {
		quotes.put("USDEUR", 0.821304);
		quotes.put("USDGBP", 0.731368);
		obj.put("Quotes", quotes);
		obj.put("Date","01-01-2021");
		assertEquals(obj.toString(),h.getQuotes().toString());




	}



}