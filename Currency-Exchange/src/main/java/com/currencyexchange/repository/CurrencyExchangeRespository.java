package com.currencyexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currencyexchange.beans.CurrencyExchange;

@Repository
public interface CurrencyExchangeRespository extends JpaRepository<CurrencyExchange, Long> {
	
	
	public CurrencyExchange findByFromAndTo(String from,String to);

}
