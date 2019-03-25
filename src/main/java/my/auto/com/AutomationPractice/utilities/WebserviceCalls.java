package my.auto.com.AutomationPractice.utilities;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WebserviceCalls {

	@Test
	public void restMethod()
	{
		Response res=RestAssured
				.given()
					.baseUri("https://reqres.in/api/users")
					.contentType("application/json")
					.body("{\r\n    \"name\": \"morpheus\",\r\n    \"job\": \"leader\"\r\n}")
				
				.when()
					.post();
		
		int status=res.getStatusCode();
		System.out.println(status);
		
		String resBody=res.getBody().asString();
		System.out.println(resBody);
		
		long timetaken=res.getTime();
		System.out.println(timetaken);
	}
	
	@Test
	public void soapMethod()
	{
		Response res=RestAssured
				.given()
					.baseUri("http://localhost:8080/CreatedProject")
					.contentType("text/xml")
					.body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:test=\"http://test/\">\r\n   <soapenv:Header/>\r\n   <soapenv:Body>\r\n      <test:add>\r\n         <arg0>29</arg0>\r\n         <arg1>8999</arg1>\r\n         <arg2>10</arg2>\r\n      </test:add>\r\n   </soapenv:Body>\r\n</soapenv:Envelope>")
				
				.when()
					.post();
		
		int status=res.getStatusCode();
		System.out.println(status);
		
		String resBody=res.getBody().asString();
		System.out.println(resBody);
		
		long timetaken=res.getTime();
		System.out.println(timetaken);
	}
}
