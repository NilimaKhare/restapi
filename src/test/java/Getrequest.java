
import org.testng.annotations.Test;

import io.restassured.http.Headers;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Getrequest {
	@Test
  	void getuserdetails() {
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RequestSpecification httprequet = RestAssured.given();
		
		Response response  =httprequet.request(Method.GET, "/2");
		
		String responsebody =response.getBody().asString();
		System.out.println(" +response body" + responsebody);
		
		
		int statuscode =  response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
		
		/*String statusline = response.getStatusLine();
		System.out.println(statusline);
		Assert.assertEquals(statusline, " HTTP/1.1 200 OK");*/
		
		
		Headers allheader = response.headers();
	for (Header header: allheader)	{
		System.out.println(header.getName()+"  "+ header.getValue());
	}
	}
	
	
	
}
