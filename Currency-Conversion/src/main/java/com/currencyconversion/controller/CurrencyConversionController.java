package com.currencyconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currencyconversion.beans.CurrencyConversion;
import com.currencyconversion.client.CurrenecyConversionClient;

@RestController
public class CurrencyConversionController {
	
	
	private CurrenecyConversionClient client;
	
	
	@Autowired
	public CurrencyConversionController(CurrenecyConversionClient client) {
		super();
		this.client = client;
	}


	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion currencyCalculation(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		HashMap<String, String> urivariale=new HashMap<>();
		urivariale.put("from", from);
		urivariale.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8686/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class, urivariale);
		
		CurrencyConversion conversion = responseEntity.getBody();
		
		CurrencyConversion currencyConversion=new CurrencyConversion(conversion.getId(),
				from, to, 
				conversion.getConversionMultiple(), quantity, 
				conversion.getConversionMultiple().multiply(quantity),
				conversion.getEnv());
		
		return currencyConversion;
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion cuConversion(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		CurrencyConversion conversion = client.retivecuConversion(from, to);
		
		CurrencyConversion finalConversion=new CurrencyConversion(conversion.getId(), 
				from, 
				to,
			     conversion.getConversionMultiple(), 
				quantity, 
				quantity.multiply(conversion.getConversionMultiple()),
				conversion.getEnv());
		
		return finalConversion;
		
	}

}
