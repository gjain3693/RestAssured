package utility;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;


@Listeners(ExtentReportListner.class)
public class BaseTest extends ExtentReportListner{

   @BeforeClass
    public void utilTest() {

       RestAssured.baseURI = Env.envFile().get("baseUrl");

      System.out.println(":::Value::"+Env.envFile().get("baseUrl"));

    }
}
