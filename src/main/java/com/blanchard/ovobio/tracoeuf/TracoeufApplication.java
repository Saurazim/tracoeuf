package com.blanchard.ovobio.tracoeuf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Benjamin Le Gall
 */
@SpringBootApplication
@EnableSwagger2
//@EnableCaching
public class TracoeufApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TracoeufApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TracoeufApplication.class, args);
		System.out.println("TracoeufApplication");
	}

}
