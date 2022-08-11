package com.vigs.springboot.multipledb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication

/**vig: 
 * somebody on internet forums mentioned this exclusion EnableAutoConfiguration(exclude =) to resolve a problem
 * Nope!!!, 
 * its not required, its the properties in application.properties that need to be setup a bit differently from normal default way
 */
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)

public class SpringBootMultipleDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultipleDbDemoApplication.class, args);
	}

}
