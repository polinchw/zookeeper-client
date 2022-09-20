package com.bpe.zookeeper.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// @RunWith(SpringJUnit4ClassRunner.class)
public class AppTests {

	@Test
	public void contextLoads() {
		assertEquals("yes", "no");
	}

    // @Test
	// public void testMethod() throws Exception {
	// 	org.junit.Assert.assertTrue( new ArrayList<String>().isEmpty() );

	// 	int zkPort = 9030;
	// 	TestingServer server = new TestingServer(zkPort);

	// 	int port = 9031;

	// 	ConfigurableApplicationContext context = new SpringApplicationBuilder(
	// 			App.class).run("--server.port=" + port,
	// 					"--spring.config.use-legacy-processing=true",
	// 					"--management.endpoints.web.exposure.include=*",
	// 					"--spring.cloud.zookeeper.connect-string=localhost:" + zkPort);

	// 	ResponseEntity<String> response = new TestRestTemplate()
	// 			.getForEntity("http://localhost:" + port + "/hi", String.class);
	// 	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	// 	context.close();
	// 	server.close();
	// }



}