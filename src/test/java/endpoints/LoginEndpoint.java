package endpoints;

import io.restassured.response.Response;
import pojos.authorization.AuthPojo;
import pojos.authorization.TokenPojo;

import static io.restassured.RestAssured.given;

public class LoginEndpoint {

    public String createToken(){
        AuthPojo authPayload = new AuthPojo("admin", "password");

        return  given()
                .body(authPayload)
                .post("https://automationintesting.online/auth/login")
                .jsonPath().getString("token");
    }
}
