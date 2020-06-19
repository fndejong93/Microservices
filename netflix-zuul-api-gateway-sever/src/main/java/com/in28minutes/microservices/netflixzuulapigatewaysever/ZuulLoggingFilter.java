package com.in28minutes.microservices.netflixzuulapigatewaysever;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// Should this filter be executed, you can say for which actions is does and doesn't, now set for all of them
	@Override
	public boolean shouldFilter() {
		return true;
	}

	// The logic of the filter will be in this method
	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		
		return null;
	}

	// When should the filter happening: before ("pre"), after ("post") or only error requests ("error") the request
	@Override
	public String filterType() {
		return "pre";
	}

	// If you have multiple filters you can set the priority for them
	@Override
	public int filterOrder() {
		return 1;
	}

}
