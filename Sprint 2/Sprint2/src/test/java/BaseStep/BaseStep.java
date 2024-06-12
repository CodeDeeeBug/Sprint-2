package BaseStep;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseStep {
	
	RequestSpecification req;
	Response res;
 
	public RequestSpecification baseURL(String url) {
		RestAssured.baseURI = url;
		req = RestAssured.given().header("Content-Type", "application/json");
		return req;
	}
 
	public Response getRequest(String endpoint) {
		return req.get(endpoint);
	}
 
	public Response postRequest(String endpoint) {
		return req.post(endpoint);
	}
 
	public Response putRequest(String endpoint) {
		return req.put(endpoint);
	}
	
	public Response patchRequest(String endpoint) {
		return req.patch(endpoint);
	}
 
	public Response deleteRequest(String endpoint) {
		return req.delete(endpoint);
	}

}
