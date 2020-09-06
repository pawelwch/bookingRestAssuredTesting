package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass{


    @BeforeClass
    public void setupConfiguration() {
        RestAssured.baseURI = "https://automationintesting.online";
        RestAssured.basePath = "/";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType("application/json");
        requestSpecBuilder.setAccept("application/json");
        requestSpecBuilder.addFilter(new AllureRestAssured());
        RestAssured.requestSpecification = requestSpecBuilder.build();
    }


}
