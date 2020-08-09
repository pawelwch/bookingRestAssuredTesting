package endpoints;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BrandingEndpoint {

    // GET information about branding

    public Response getBranding() {
        return given().contentType("application/json").log().all()
                .when().get("https://automationintesting.online/branding/");
    }
}
