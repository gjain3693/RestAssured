package regressionTest;

import apiutility.ApiEndPoint;
import apiutility.HeaderConfig;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.User;

public class DeleteApi extends BaseTest {

    @Test
    public void deleteUser() {
        HeaderConfig header = new HeaderConfig();
        String userNumber = "518";
        test.log(LogStatus.INFO, "Test case for delete user started");


        Response response = RestAssured.given()
                .headers(header.defaultHeaders())
                .when()
                .delete(ApiEndPoint.apiPath.DELETE_USER+userNumber)
                .then()
                .extract()
                .response();
        System.out.println("Response:::"+response.prettyPrint());
        System.out.println("Response:::"+response.getStatusCode());

        try {
            Assert.assertEquals(204,response.getStatusCode());
            test.log(LogStatus.PASS, "Test case Pass");

        } catch(AssertionError ae) {
            test.log(LogStatus.INFO,response.prettyPrint());
            test.log(LogStatus.FAIL, "Test case FAIL");
        }

        test.log(LogStatus.INFO, "Test case for delete user finish");
    }

}

