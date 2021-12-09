package com.progettoOOP.CurrencyLayer.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.progettoOOP.CurrencyLayer.service.HistoricalRate;
import com.progettoOOP.CurrencyLayer.model.Day;

import org.springframework.http.HttpStatus;
@RestController

public class Controller {
	@GetMapping("/rates")

	public ResponseEntity<Object> getRates(
			@RequestParam (name= "currency_list", defaultValue = "EUR,GBP") String currency_list,
			@RequestParam (name = "year", defaultValue = "2020") String year, 
			@RequestParam (name = "month", defaultValue = "12") String month,
			@RequestParam (name = "day", defaultValue = "12") String day)
			  {
HistoricalRate h = new HistoricalRate(currency_list,new Day(year,month,day));
	
return new ResponseEntity<> ((h.getJSON().toString()),HttpStatus.OK);
}

}
