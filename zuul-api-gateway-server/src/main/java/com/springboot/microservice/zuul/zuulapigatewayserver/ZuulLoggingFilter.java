package com.springboot.microservice.zuul.zuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/* To Enable or disable this ZuulLoggingFilter 
	 * thats is this filter will be executed here or not
	 * */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/* This is the method where we will write our own logic for this filter */
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request,request.getRequestURI());
		return null;
	}

	/* when should be filtering happens
	 * "pre" - before the request should be executed
	 * "post" - after the request should be executed
	 * "error" - do you want to filter only error ie, request which cause exception to be happened to be executed 
	 * */
	@Override
	public String filterType() {
		return "pre";
	}

	//If we have multiple filters then on which priority order each filter runs we can decide that from here
	@Override
	public int filterOrder() {
		return 1;
	}

}
