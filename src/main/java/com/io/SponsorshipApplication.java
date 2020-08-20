package com.io;
import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mamta Soni
 * @date Aug 17, 2020
 * @version java 1.8
 * 
 */
@SpringBootApplication
@RestController
public class SponsorshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(SponsorshipApplication.class, args);
	}
	
	@GetMapping(value="/google/user-info") 
	public Principal user(Principal  principal) { 
		return principal; 
	}

}
