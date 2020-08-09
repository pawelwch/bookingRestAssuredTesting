package endpoints;

import org.testng.annotations.Test;
import pojos.message.MessagePojo;
import tests.HelperMethods;

import static io.restassured.RestAssured.given;

public class MessageEndpoint {


    public void postMessage() {
        MessagePojo messagePojo = new MessagePojo();
        messagePojo.setName("Full Name");
        messagePojo.setEmail("email@email.com");
        messagePojo.setPhone(HelperMethods.generatePhone());
        messagePojo.setSubject(HelperMethods.generateRandomString(12));
        messagePojo.setDescription("Description to be continued");

        given().body(messagePojo).contentType("application/json").log().all()
                .when().post("https://automationintesting.online/message/")
                .then().statusCode(201).log().all();
    }
}
