package com.example.xfwdheaders

import com.example.xfwdheaders.rest.HelloRestController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient


@WebFluxTest(HelloRestController::class)
class NativeXfwdHeadersApplicationTests {

	@Autowired
	lateinit var webTestClient: WebTestClient

	@Test
	fun contextLoads() {
		webTestClient.get()
			.uri("/hello")
			.header("x-forwarded-host", "localhost:3000")
			.exchange()
			.expectStatus().isOk
			.expectBody(String::class.java)
	}

}
