package com.bpe.zookeeper.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.curator.test.TestingServer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AppTests {

    @Test
	public void testMethod() throws Exception {

		int zkPort = 9030;
		TestingServer server = new TestingServer(zkPort);

		int port = 9031;

		ConfigurableApplicationContext context = new SpringApplicationBuilder(
				App.class).run("--server.port=" + port,
						"--spring.config.use-legacy-processing=true",
						"--management.endpoints.web.exposure.include=*",
						"--spring.cloud.zookeeper.connect-string=localhost:" + zkPort);

		ResponseEntity<String> response = new TestRestTemplate()
				.getForEntity("http://localhost:" + port + "/", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);

		context.close();
		server.close();
	}



}