package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.Payload;
import utils.constance;

import static io.restassured.RestAssured.given;

public class apiFirst {

    RequestSpecification request;
    Response response;
    String employeeId;

    @Given("a request is prepared to create an Employee")
    public void a_request_is_prepared_to_create_an_employee() {

      request= given().header(constance.Header_Content_Type_Key,constance.Content_type_Value).
                header(constance.Header_Authorization_key,tokenReader.token).
                body(Payload.createEmployeePayload());


    }
    @When("a post call is made to the endpoint")
    public void a_post_call_is_made_to_the_endpoint() {
        Response response=request.when().post(constance.CREATE_EMPLOYEE_URI);
    }
    @Then("the status code is {int}")
    public void the_status_code_is(Integer statuscode) {
        response.then().assertThat().statusCode(statuscode);
    }

    @Then("the employee id {string} is stored as a global variable")
    public void the_employee_id_is_stored_as_a_global_variable(String empId) {
       employeeId= response.jsonPath().getString(empId);
    }

    @Then("we verify that the value for key {string} is {string}")
    public void we_verify_that_the_value_for_key_is(String key, String expectedValue) {
       String  actualValue=response.jsonPath().get(key);
        Assert.assertEquals(expectedValue,actualValue);

    }
}
