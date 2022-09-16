import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.RestAssured;

import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class Postrequest {
	@Test (dataProvider="empdataprovider")
	void postuserdetails(String email,String password) {
		
        RestAssured.baseURI="https://reqres.in/api/user";
		
		RequestSpecification httprequet = RestAssured.given();
		 JSONObject requestpara = new JSONObject();
		
		 requestpara.put("email" ,email );
		 requestpara.put("password",password);
		 httprequet.header("Content-Type","application/json; charset=utf-8");
		 httprequet.body(requestpara.toJSONString());
		 Response response =   httprequet.request(Method.POST,"/register");
		 String responsebody =response.getBody().asString();
		 
		 System.out.println("Response Body is:" +responsebody);
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		 // Assert.assertEquals(statusCode, 201);
		 
		  //success code validation
		 /* String successCode=response.jsonPath().get("SuccessCode");
		  Assert.assertEquals(successCode,true);
		 */
}  
	@DataProvider(name="empdataprovider")
	String [][] getdata() throws Exception{
	
	  String path = System.getProperty("user.dir")+"/src/test/java/data driven.xlsx";
	  
	     int rowNUM=Utilclass.getRowCount(path,"Sheet1");
	int colcount=Utilclass.getCellCount(path, "Sheet1", 1);
	String empdata [][] = new String [rowNUM][colcount];
	
        for(int i= 1;i<=rowNUM;i++) {
	for(int j= 0;j<=colcount;j++) {
		
		empdata[i-1][j]=Utilclass.getCellData(path, "Sheet1", i, j);
	}
}
		return empdata; 
	}
}