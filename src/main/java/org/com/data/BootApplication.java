/**
 * 
 */
package org.com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author sanjsingh
 *
 */

@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
public class BootApplication {

	public static void main(String[] args) {

		SpringApplication.run(BootApplication.class, args);

	}

}
