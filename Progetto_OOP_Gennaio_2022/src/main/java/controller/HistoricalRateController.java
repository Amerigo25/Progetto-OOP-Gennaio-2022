package controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.HistoricalRate;
import org.json.simple.JSONObject;
import model.Day;
@RestController
public class HistoricalRateController {
	@Autowired
	HistoricalRate historicalrate;
	@GetMapping("/rates")

		public ResponseEntity<Object> getRates(
				@RequestParam (name= "currency_list", defaultValue = "EUR,GBP") String currency_list,
				@RequestParam (name = "year", defaultValue = "2020") String year, 
				@RequestParam (name = "month", defaultValue = "31") String month,
				@RequestParam (name = "day", defaultValue = "12") String day)
				  {
		
return new ResponseEntity<> ((historicalrate.getJSON(currency_list,new Day(year,month,day))),HttpStatus.OK);

			
		}
}




			
			
	



