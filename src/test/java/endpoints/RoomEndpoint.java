package endpoints;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojos.room.RoomPojo;

import static io.restassured.RestAssured.given;

public class RoomEndpoint {

    // GET all rooms
    public Response getRoom() {
        return given().contentType("application/json").log().all()
                .when().get("https://automationintesting.online/room/");
    }

//    public Response postRoom() {
//        RoomPojo roomPojo = new RoomPojo();
//        roomPojo.setType("asd");
//        roomPojo.setAccessible(true);
//
//        return given().contentType("application/json").log().all()
//
//    }
}
