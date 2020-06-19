package com.in28minutes.microservices.limitsservice;

import com.in28minutes.microservices.limitsservice.bean.LimitConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private Configuration configuration;


    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations() {
    	logger.info("Retrieved maximum and minimum limit");
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }
}
