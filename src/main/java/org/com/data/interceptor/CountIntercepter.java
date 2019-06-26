/**
 * 
 */
package org.com.data.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sanjsingh
 *
 */
@Configuration
@Component
public class CountIntercepter implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(CountIntercepter.class);

	private static  int START_COUNT = 9;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("Prehandale method ");

		if (request.getAttribute("Count") == null) {
			request.setAttribute("Count", START_COUNT);

			System.out.println("Set Counter Attribute by value: " + START_COUNT);
		}

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("Counter postHandle method ");

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("Counter afterCompletion method ");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
