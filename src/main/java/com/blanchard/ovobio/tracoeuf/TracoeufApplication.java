package com.blanchard.ovobio.tracoeuf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Benjamin Le Gall
 */
@SpringBootApplication
@EnableSwagger2
//@EnableCaching
public class TracoeufApplication {

	public static void main(String[] args) {
		SpringApplication.run(TracoeufApplication.class, args);
	}

}
