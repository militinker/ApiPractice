package steps;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Payload;
import utils.constance;

import java.io.IOException;
import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;



public class tokenReader {
    public static String token;

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
    RequestSpecification request= given().header(constance.Header_Content_Type_Key,constance.Content_type_Value)
        .body(Payload.generateTokenPayload());
    Response response=request.when().post(constance.GENERATE_TOKEN_URI);
    String rawToken= response.jsonPath().getString("token");
    token = "Bearer "+rawToken;
    }



}
