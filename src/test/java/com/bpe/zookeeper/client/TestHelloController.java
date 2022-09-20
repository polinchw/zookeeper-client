package com.bpe.zookeeper.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.apache.curator.test.TestingServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHelloController {

    @Test
	public void method() throws Exception {
		org.junit.Assert.assertTrue( new ArrayList<String>().isEmpty() );

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