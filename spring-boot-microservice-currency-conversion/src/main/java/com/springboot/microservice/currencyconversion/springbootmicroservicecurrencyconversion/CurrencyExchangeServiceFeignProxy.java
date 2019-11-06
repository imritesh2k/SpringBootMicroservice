package com.springboot.microservice.currencyconversion.springbootmicroservicecurrencyconversion;

@FeignClient(name="forex-service" url="localhost:8000")
public interface CurrencyExchangeServiceFeignProxy {
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public CurrencyConversionBean retrieveExchangeValue
    (@PathVariable("from") String from, @PathVariable("to") String to);
}
