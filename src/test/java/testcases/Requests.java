package testcases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Requests {

	String baseURL = "https://reqres.in";

	@Test(description = "Method to demonstrate get method using path parameters")
	public void getMethodwithPathParam() {

		Response res = given().when().get(baseURL + "/api/users?page=2");

		System.out.println(res.asString());
		System.out.println(res.asPrettyString());

	}

	@Test
	public void PostMethod() {

		Response res = given().header("Content-Type", "application/json")
				.body("{\"name\":\"morpheus\",\"job\":\"leader\"}").when().post("https://reqres.in/api/users");
		System.out.println(res.asPrettyString());
	}

}
