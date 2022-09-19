package com.bpe.zookeeper.client;

import org.apache.curator.test.TestingServer;
import org.junit.Test;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
public class HelloControllerTest {

    @Test
	public void testIt() throws Exception {
		int zkPort = 9030;
		TestingServer server = new TestingServer(zkPort);

		int port = 9031;

		ConfigurableApplicationContext context = new SpringApplicationBuilder(
				App.class).run("--server.port=" + port,
						"--spring.config.use-legacy-processing=true",
						"--management.endpoints.web.exposure.include=*",
						"--spring.cloud.zookeeper.connect-string=localhost:" + zkPort);

		ResponseEntity<String> response = new TestRestTemplate()
				.getForEntity("http://localhost:" + port + "/hi", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		context.close();
		server.close();
	}




}