package com.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.currencyexchange.beans.CurrencyExchange;
import com.currencyexchange.repository.CurrencyExchangeRespository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRespository currencyExchangeRespository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrivecurrency(@PathVariable String from,@PathVariable String to) {
		
		CurrencyExchange ce = currencyExchangeRespository.findByFromAndTo(from, to);
		
		String property = environment.getProperty("local.server.port");
		
		ce.setEnv(property);
		
		return ce; 
	}
	
	
	@PostMapping("/currency-exchange")
	public CurrencyExchange save(@RequestBody CurrencyExchange ce) {
		
		return currencyExchangeRespository.save(ce);
	}

}
