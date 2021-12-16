package regressionTest;

import apiutility.ApiEndPoint;
import apiutility.HeaderConfig;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.User;

public class PostApi extends BaseTest {

    @Test
    public void createUser() {

        HeaderConfig header = new HeaderConfig();
        User user = new User();

        user.setName("Nick");
        user.setJob("Test Lead");

        test.log(LogStatus.INFO, "Test case for create user started");


        Response response = RestAssured.given()
                .headers(header.defaultHeaders())
                .when()
                .body(user)
                .post(ApiEndPoint.apiPath.CREATE_USER)
                .then()
              // .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("createUserSchema.json"))
                .extract()
                .response();
        System.out.println("Response:::"+response.prettyPrint());
        System.out.println("Response:::"+response.getStatusCode());

        try {
            Assert.assertEquals(201,response.getStatusCode());
            test.log(LogStatus.PASS, "Test case Pass");

        } catch(AssertionError ae) {
            test.log(LogStatus.INFO,response.prettyPrint());
            test.log(LogStatus.FAIL, "Test case FAIL");
        }

        test.log(LogStatus.INFO, "Test case for create user finish");
    }

    }
