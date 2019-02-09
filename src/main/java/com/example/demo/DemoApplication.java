package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	@RequestMapping(path = "/test")
	static class Controller {

		@Value("${myproperty1}")
		private String property1;

		@Value("${myproperty2}")
		private String property2;

		@Value("${myproperty3}")
		private String property3;

		@GetMapping("/property1")
		public String getEncrypted1() {
			return property1;
		}

		@GetMapping("/property2")
		public String getEncrypted2() {
			return property2;
		}

		@GetMapping("/property3")
		public String getEncrypted3() {
			return property3;
		}
	}

}

