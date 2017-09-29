package rest;


import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import org.junit.Test;


public class GetMethodOperations {
	
	//http://toolsqa.com/rest-assured/rest-assured-test/
	
	@Test
	public void getDetailsDefault()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
	
		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

	}
	
	
	/**
	 * This method will get response and print response body.
	 */
	
	@Test
	public void getDetails() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		Response response = given().when().get("/Hyderabad");
		String details = response.getBody().asString();
	
		System.out.println("Response::" + details);
		
		
	}
	
	
	/**
	 *This method will verify value received in response. 
	 */
	
	@Test
	public void verifyDetails() {
		String city = "Hyderabad";
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		Response response = given().when().get("/Hyderabad");
		String json = response.asString();
		JsonPath jp = new JsonPath(json);
		System.out.println(jp.get("City"));
		Assert.assertEquals(city, jp.get("City"));
		
		
	}

	
}
