package com.springboot.microservice.currencyconversion.springbootmicroservicecurrencyconversion;


import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionFeignController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	//private CurrencyExchangeServiceFeignProxy proxy;
	private CurrencyExchangeServiceFeignProxyRibbon proxy;
	
	//http://localhost:8100/currency-converter/feign/from/EUR/to/INR/quantity/10000
	
	@GetMapping("/currency-converter/feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		logger.info("{}", response);

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
		
		
	}

}
