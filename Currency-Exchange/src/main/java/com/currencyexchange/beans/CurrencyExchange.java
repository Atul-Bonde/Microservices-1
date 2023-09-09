package com.currencyexchange.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="CURRENCY")
public class CurrencyExchange {
	
	@Id
	private Long id;
	
	@Column(name="CURRENCY_FROM")
	private String from;
	
	@Column(name="CURRENCY_TO")
	private String to;
	
	@Column(name="CONVERSION_MULTIPLE")
	private BigDecimal conversionMultiple;

	@Column(name="Env")
	private String env;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", env=" + env + "]";
	}

	public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMultiple, String env) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.env = env;
	}

	public CurrencyExchange() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
