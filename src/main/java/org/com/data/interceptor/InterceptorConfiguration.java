package org.com.data.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(InterceptorConfiguration.class);

	@Autowired
	private AdminInterceptor adimInterceptor;
	@Autowired
	private CountIntercepter countIntercepter;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		logger.info("Interceptar Implemented ");
		registry.addInterceptor(adimInterceptor);
		registry.addInterceptor(countIntercepter);
	}

}
