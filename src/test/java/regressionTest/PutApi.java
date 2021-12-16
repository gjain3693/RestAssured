package regressionTest;

import apiutility.ApiEndPoint;
import apiutility.HeaderConfig;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.User;

public class PutApi extends BaseTest {


    @Test
     public void updateUser() {
        String userId = "518";

        HeaderConfig header = new HeaderConfig();
        User user = new User();

        user.setName("Gaurav");
        user.setJob("Test Lead");

        test.log(LogStatus.INFO, "Test case for create user started");

        Response response = RestAssured.given()
                .headers(header.defaultHeaders())
                .when()
                .body(user)
                .put(ApiEndPoint.apiPath.UPDATE_USER+userId)
                .then()
                .extract()
                .response();

        System.out.println("Response:::"+response.prettyPrint());
        System.out.println("Response:::"+response.getStatusCode());

        try {
            Assert.assertEquals(200,response.getStatusCode());
            test.log(LogStatus.PASS, "Test case for update user pass");
        } catch (AssertionError ae) {
            test.log(LogStatus.INFO,response.prettyPrint());
            test.log(LogStatus.FAIL, "Test case for update user fail");
        }

    }
}
