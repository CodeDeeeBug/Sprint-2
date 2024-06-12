package StepDefinition;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.AssertJUnit;

import BaseStep.BaseStep;
import FileReader.FileReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthDefinition {

    // Creating class object as global object to call in all the other classes.
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

    // -----------------Authorize------------------------------------
    @When("User enters userName and password as basic auth")
    public void user_enters_user_name_and_password_as_basic_auth() throws Exception {
        req.auth().basic(fileReader.properties("Username"), fileReader.properties("Password"));
    }

    @When("User enter userName and password in body")
    public void user_enter_user_name_and_password_in_body(DataTable dataTable) {
        obj = new JSONObject();
        obj.put("userName", dataTable.cell(1, 0)); 
        obj.put("password", dataTable.cell(1, 1));
        req.body(obj.toJSONString());
    }

    @When("User clicks on send option")
    public void user_clicks_on_send_option() throws Exception {
        fileReader = new FileReader();
        res = base.postRequest(fileReader.properties("Authorize"));
        path = res.jsonPath();
        System.out.println(res.asPrettyString());
    }

    @Then("User should get Authorized successfully")
    public void user_should_get_authorized_successfully() {
        AssertJUnit.assertEquals(res.asPrettyString(), "true");
    }

    // --------------------------Token-----------------------------------
    @When("User enters {string} and {string} in body")
    public void user_enters_and_in_body(String userName, String password) throws Exception {
        
        obj = new JSONObject();
        obj.put("userName", userName);
        obj.put("password", password);
        req.body(obj.toJSONString());
    }

    @And("user click on send option to post")
    public void user_click_on_send_option_to_post() throws Exception {
    	fileReader = new FileReader();
//    	 res = req.post("/Account/v1/GenerateToken");
        res = req.post(fileReader.properties("Token"));
        path = res.jsonPath();
        System.out.println(res.asPrettyString());
    }

    @Then("Token should get generated")
    public void token_should_get_generated() {
        String token = path.getString("token");
        Assert.assertNotNull(token, "Token should not be null");
        System.out.println("Generated token: " + token);
    }
}
