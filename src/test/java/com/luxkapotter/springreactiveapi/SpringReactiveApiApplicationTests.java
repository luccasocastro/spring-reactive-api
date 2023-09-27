package com.luxkapotter.springreactiveapi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringReactiveApiApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void test() {
		User user = new User(null, "luccas", "12345", "email@mail.com");

		webTestClient
			.post()
			.uri("/users")
			.bodyValue(user)
			.exchange()
			.expectBody(User.class)
			.value(postResponse -> {
				assertNotNull(postResponse.id());
				assertEquals(user.username(), postResponse.username());
				assertEquals(user.email(), postResponse.email());
				assertEquals(user.password(), postResponse.password());
			});
		
			webTestClient
			.get()
			.uri("/users")
			.exchange()
			.expectStatus().is2xxSuccessful()
			.expectBodyList(User.class)
			.value(getResponses -> {
				User getResponse = getResponses.get(0);
				assertNotNull(getResponse.id());
				assertEquals(user.username(), getResponse.username());
				assertEquals(user.email(), getResponse.email());
				assertEquals(user.password(), getResponse.password());
			});
	}

}
