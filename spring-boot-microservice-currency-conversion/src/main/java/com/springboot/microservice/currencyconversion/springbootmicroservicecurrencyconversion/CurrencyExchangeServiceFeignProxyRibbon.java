package com.springboot.microservice.currencyconversion.springbootmicroservicecurrencyconversion;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="forex-service")
@FeignClient(name="zuul-api-gateway-server") //For request to go through the api gateway
@RibbonClient(name="forex-service")
public interface CurrencyExchangeServiceFeignProxyRibbon {
  //@GetMapping("/currency-exchange/from/{from}/to/{to}")
  @GetMapping("/forex-service/currency-exchange/from/{from}/to/{to}") //For request to go through the api gateway
  public CurrencyConversionBean retrieveExchangeValue
    (@PathVariable("from") String from, @PathVariable("to") String to);
}
