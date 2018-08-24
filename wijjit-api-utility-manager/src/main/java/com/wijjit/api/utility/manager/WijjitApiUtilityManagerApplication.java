package com.wijjit.api.utility.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.wijjit.jwt.api.security", "com.wijjit.api.utility.manager"})
public class WijjitApiUtilityManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WijjitApiUtilityManagerApplication.class, args);
	}
}
