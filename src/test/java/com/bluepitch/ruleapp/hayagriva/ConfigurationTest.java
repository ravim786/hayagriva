package com.bluepitch.ruleapp.hayagriva;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = HayagrivaApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) 
public class ConfigurationTest {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testConfiguration() throws Exception {
        RestAssured.port = randomServerPort;
        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body("{" +
                "\"context\": {" +
                    "\"submittedDate\": \"2021-04-14\"" +
                "}" +
            "}")
            .when()
                .post("/hayagriva/configuration")
            .then()
                .statusCode(200)
                .body("anticipatedREOSalesProceedsAdjustmentFactor", equalTo(0.9f));
    
    }

}
