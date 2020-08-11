package endpoints;

import pojos.room.RoomPojo;

import static io.restassured.RestAssured.given;

public class RoomEndpoint {

    // GET all rooms
    public RoomPojo getRooms() {
        return given().contentType("application/json").log().all()
                .when().get("https://automationintesting.online/room/")
                .then().extract().as(RoomPojo.class);
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
