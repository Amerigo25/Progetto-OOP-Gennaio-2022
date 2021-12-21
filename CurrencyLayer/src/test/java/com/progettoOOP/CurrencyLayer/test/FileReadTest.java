package com.progettoOOP.CurrencyLayer.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.progettoOOP.CurrencyLayer.service.FileRead;
/**
 * Questa classe testa il metodo di lettura dati da file
 * @author Amerigo Aloisi
 *
 */
public class FileReadTest {
	private FileRead f;
	private JSONArray array;
	private JSONObject obj1,obj2,quotes;
@BeforeEach
void setUp() throws Exception {
	f=new FileRead();
	array=new JSONArray();
	obj1=new JSONObject();
	obj2=new JSONObject();
	quotes=new JSONObject();

}
@AfterEach
void tearDown()throws Exception{
}
	
@SuppressWarnings("unchecked")
@Test
@DisplayName("Lettura da file andata a buon fine")
/**
 * Questo metodo verifica la correttezza della lettura da file
 */
void getJSONfromFileTest() {
	array=f.getJSONfromFile();
	obj1=(JSONObject)array.get(0);
	quotes.put("USDEUR", 0.872505);
	quotes.put("USDGBP", 0.7841);
	quotes.put("USDBTC",2.6E-4 );
    obj2.put("Quotes", quotes);
	obj2.put("Date","01-01-2019");
	 assertEquals(obj1.toString(),obj2.toString());
	
	
}


}