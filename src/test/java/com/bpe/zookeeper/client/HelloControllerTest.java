package com.bpe.zookeeper.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
// @IntegrationTest({"server.port:0",
//         "spring.datasource.url:jdbc:h2:mem:zookeeper-client;DB_CLOSE_ON_EXIT=FALSE"})
public class HelloControllerTest {

    @Test
    public void testIt() throws Exception {
        assert true;
    }


    // @Test
    // public void testHello() throws Exception {
    //     when().get("/").then()
    //             .body(is("Hello World!"));
    // }

    // @Test
    // public void testCalc() throws Exception {
    //     given().param("left", 100)
    //             .param("right", 200)
    //             .get("/calc")
    //             .then()
    //             .body("left", is(100))
    //             .body("right", is(200))
    //             .body("answer", is(300));
    // }
}