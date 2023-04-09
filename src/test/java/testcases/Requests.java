package testcases;

import static io.restassured.RestAssured.given;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import resources.Log4j;

public class Requests {

	String baseURL = "https://reqres.in";

	@Test(description = "Method to demonstrate get method using path parameters")
	public void getMethodwithPathParam() {

		DOMConfigurator.configure("log4j.xml");
		Log4j.startTestCase("getMethodwithPathParam");
		Response res = given().when().get(baseURL + "/api/users?page=2");
		Assert.assertEquals(res.getStatusCode(), 200);
		Log4j.info(res.asPrettyString());
		// System.out.println(res.asString());
		System.out.println(res.asPrettyString());

	}

	@Test
	public void PostMethod() {
		DOMConfigurator.configure("log4j.xml");
		Log4j.startTestCase("PostMethod");
		Response res = given().header("Content-Type", "application/json")
				.body("{\"name\":\"morpheus\",\"job\":\"leader\"}").when().post("https://reqres.in/api/users");
		System.out.println(res.asPrettyString());
		Log4j.info(res.asPrettyString());
	}

}
