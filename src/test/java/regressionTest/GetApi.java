package regressionTest;

import apiutility.ApiEndPoint;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;
import utility.BaseTest;

public class GetApi extends BaseTest {

    @Test
    public void getUsers() {

        test.log(LogStatus.INFO,"Test case started");

       Response response = RestAssured.given()
                .when()
                .get(ApiEndPoint.apiPath.GET_MULTI_USER)
                .then()
                .extract()
                .response();
        System.out.println("response value:::"+response.prettyPrint());

        try {
            Assert.assertEquals(200,response.getStatusCode());
            test.log(LogStatus.PASS,"Test case for Get user data passed");
        } catch (AssertionError ae) {
            test.log(LogStatus.INFO,response.prettyPrint());
            test.log(LogStatus.FAIL,"Test case failed" +" "+ ae.getMessage());
        }

    }

    @Test
    public void getUsersList() {
        String userNumber = "2";
        Response response = RestAssured.given()
                .when()
                .get(ApiEndPoint.apiPath.GET_USER+userNumber)
                .then()
                .extract()
                .response();
        System.out.println("response value:::"+response.prettyPrint());

        JsonPath jsonPathEvaluator = response.jsonPath();
        String fname = jsonPathEvaluator
                .get("data.first_name");
        System.out.println("First Name:"+fname);

        try {
            Assert.assertEquals(200,response.getStatusCode());
            Assert.assertEquals("Janet",fname);
            test.log(LogStatus.PASS,"Test case for Get user data passed");
        } catch (AssertionError ae) {
            test.log(LogStatus.INFO,response.prettyPrint());
            test.log(LogStatus.FAIL,"Test case failed" +" "+ ae.getMessage());
        }
    }

}
