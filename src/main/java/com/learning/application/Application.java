package com.learning.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
 
 
@SpringBootApplication(scanBasePackages={"com.learning"}, exclude = JpaRepositoriesAutoConfiguration.class)
public class Application {
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
