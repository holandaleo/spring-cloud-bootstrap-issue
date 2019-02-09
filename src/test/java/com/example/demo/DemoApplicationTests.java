package com.example.demo;

import java.time.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("developers,local")
public class DemoApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Autowired
	private DemoApplication.Controller controller;

	@Test
	public void case1() {
		webTestClient.get()
				.uri("/test/property1")
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("value-from-local-profile1");
	}

	@Test
	public void case2() {
		webTestClient.get()
				.uri("/test/property2")
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("value-from-local-profile2");
	}

	@Test
	public void case3() {
		webTestClient.get()
				.uri("/test/property3")
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("value-from-local-profile3");
	}

}

