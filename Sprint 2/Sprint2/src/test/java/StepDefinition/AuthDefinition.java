package StepDefinition;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.AssertJUnit;

import BaseStep.BaseStep;
import FileReader.FileReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class AuthDefinition {

	//Creating class object as global object to call in all the other classes.
	
	BaseStep base = new BaseStep();
	FileReader fileReader = new FileReader();
	RequestSpecification req;
	Response res;
	JsonPath path;
	JSONObject obj;
	
	
	
	
	@Given("User is on Bookstore Account Section")
	public void user_is_on_bookstore_account_section() {
		
		req = base.baseURL("https://bookstore.toolsqa.com/");
		
	}
	
	//-----------------Authorize------------------------------------
	
	@When("User enters userName and password as basic auth")
	public void user_enters_user_name_and_password_as_basic_auth() throws Exception {
	    req.auth().basic(fileReader.properties("Username"), fileReader.properties("Password"));
	}
	
	@When("User enter userName and password in body")
	public void user_enter_user_name_and_password_in_body(DataTable dataTable) {
		
		obj = new JSONObject();
		obj = fileReader.authorize(dataTable);
		req.body(obj.toJSONString());
	}
	
	@When("User clicks on send option")
	public void user_clicks_on_send_option() throws Exception {
		fileReader = new FileReader();
		res = base.postRequest(fileReader.properties("Authorize"));
		path = res.jsonPath();
		System.out.println(res.asPrettyString());
	    
	}
	
	@Then("User should Authorize successfully")
	public void user_should_authorize_successfully() {
	    AssertJUnit.assertEquals(res.asPrettyString(), true);
	    
	}
	
	
	//--------------------------Token-----------------------------------
	
	@When("^User enters (.*) and (.*) in body$")
	public void user_enters_and_in_body(String string, String string2) throws Exception {
	    RestAssured.baseURI= "https://bookstore.toolsqa.com";
	}
	
	@And("user click on send option to post")
	public void user_click_on_send_option_to_post() {
		
		/*fileReader=new FileReader();
		obj=new JSONObject();
		obj=fileReader.generateToken();
		req.body(obj.toJSONString());*/
		
		Response response = RestAssured.given()
				.header("Content-Type", "application/json")
				.body("{\"username\":\"Deepu\",\"password\":\"Deepu@123\"}")
				.when()
				.post("/Account/v1/GenerateToken")
				.then()
				.statusCode(200)
				.extract().response();
	}
	
	@Then("Toke should get generated")
	public void toke_should_get_generated() {
		
		String token = "";
		Assert.assertNotNull(token, "Token should not be null");
		System.out.println("Generated token:" +token);
	    
	}
	
}
