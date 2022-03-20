package com.contacts.mycontacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class MycontactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycontactsApplication.class, args);
	}

}
