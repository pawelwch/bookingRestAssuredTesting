package tests;

import endpoints.LoginEndpoint;
import endpoints.RoomEndpoint;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojos.authorization.AuthPojo;
import pojos.booking.BookingDatesPojo;
import pojos.booking.BookingPojo;
import pojos.branding.BrandingPojo;
import pojos.branding.BrandingContactPojo;
import pojos.branding.BrandingMapPojo;
import pojos.message.MessagePojo;
import pojos.room.RoomPojo;
import testng.TestListener;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Listeners(TestListener.class)
public class Tests extends BaseClass{

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * MESSAGE TESTS
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /** The method checks if the message was sent correctly and if the response is valid */
    @Test
    public void givenCorrectMessageDataWhenPostMessageThenMessageIsSentTest() {
        MessagePojo messagePojo = new MessagePojo();

        messagePojo.setName("Random Guy");
        messagePojo.setDescription("Just a description to be sent");
        messagePojo.setPhone(HelperMethods.generatePhone());
        messagePojo.setEmail("random@random.pl");
        messagePojo.setSubject("No subject there to be sent");

        MessagePojo response = given().body(messagePojo)
                .when().post("message/")
                .then().statusCode(201).extract().as(MessagePojo.class);

        assertEquals(response.getName(), messagePojo.getName(), "User name");
        assertEquals(response.getEmail(), messagePojo.getEmail(), "User email");
        assertEquals(response.getPhone(), messagePojo.getPhone(), "User phone number");
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * ROOMS TESTS
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /** The method checks if the request returns more than 1 room */
    @Test
    public void whenGetRoomsThenReturnMoreThanOneRoomTest() {
        List<RoomPojo> roomPojos = given()
                .when().get("room/")
                .then().extract().body().jsonPath().getList("rooms", RoomPojo.class);
        assertTrue(roomPojos.size() > 0, "List of rooms");
    }

    /** The method checks if after login Admin can post the Room and listing with all rooms can return it */
    @Test
    public void givenCorrectRoomDataWhenPostRoomThenReturnListWithNewlyCreatedRoomTest() {
        LoginEndpoint loginEndpoint = new LoginEndpoint();
        RoomPojo roomPojo = new RoomPojo();
        String token = loginEndpoint.createToken();

        roomPojo.setAccessible(true);
        roomPojo.setType("Single");
        roomPojo.setDescription("The very first single room");
        roomPojo.setImage("https://i.pinimg.com/originals/51/23/f0/5123f08b6e9c4441f27abf07cfee09c9.jpg");
        roomPojo.setRoomId(12);
        roomPojo.setRoomPrice(94);
        //roomPojo.setFeatures()
        roomPojo.setRoomNumber(22);

        given().cookie("token", token)
                .body(roomPojo)
                .when().post("room/")
                .then().statusCode(200);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * LOGIN TESTS
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /** The method checks if Admin can log in */
    @Test
    public void givenCorrectAdminUsernameAndPasswordWhenPostLoginThenAdminIsLoginTest() {
        AuthPojo authPojo = new AuthPojo("admin", "password");

        String token = given().body(authPojo)
                .when().post("/auth/login/")
                .then().assertThat().extract().path("token");

        assertThat(token, is(not(emptyString())));
        assertEquals(token.length(), 16);
    }


    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * BOOKING TESTS
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /** The method checks if after add new booking it appear in the system  */
    @Test
    public void givenCorrectBookingDataWhenPostBookingThenNewBookingIsAddedTest() {
        BookingPojo bookingPojo = new BookingPojo();
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo();

        bookingPojo.setFirstname("Pawełek");
        bookingPojo.setLastname("Nowak");
        bookingPojo.setTotalprice(999);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setAdditionalneeds("");
        bookingDatesPojo.setCheckin("2020-10-01");
        bookingDatesPojo.setCheckout("2020-10-30");
        bookingPojo.setRoomid(234);

        given().body(bookingPojo)
                .when().post("booking/")
                .then().statusCode(200);

        BookingPojo actualBooking = given().pathParam("bookingId", bookingPojo.getRoomid())
                .when().get("booking/{bookingId}/")
                .then().statusCode(200)
                .extract().as(BookingPojo.class);

        assertEquals(actualBooking.getRoomid(), bookingPojo.getRoomid(), "Room id");
        assertEquals(actualBooking.getFirstname(), bookingPojo.getFirstname(), "First name");
        assertEquals(actualBooking.getLastname(), bookingPojo.getLastname(), "Last name");
        assertEquals(actualBooking.getTotalprice(), bookingPojo.getTotalprice(), "Total price");
        assertEquals(actualBooking.getDepositpaid(), bookingPojo.getDepositpaid(), "Deposit paid");
    }

    /** The method checks if after GET a Room can we book it */
    @Test
    public void givenCorrectBookDataWhenPostBookingThenRoomIsBookedTest() {
        int roomWithIdEqualOne = given()
                .when().get("room/")
                .then().extract().jsonPath().getInt("rooms[0].roomid");
        assertThat(roomWithIdEqualOne, is(equalTo(1)));


    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * BRANDING TESTS
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    @Test
    public void givenNewBrandingDataWhenPutBrandingThenBrandingIsUpdatedTests() {
        BrandingPojo brandingPojo = new BrandingPojo();
        LoginEndpoint loginEndpoint = new LoginEndpoint();
        String token = loginEndpoint.createToken();

        BrandingContactPojo brandingContactPojo = new BrandingContactPojo();
        brandingContactPojo.setName("Paweł Nowak");
        brandingContactPojo.setAddress("ul. Długa, 53-324 Wrocław");
        brandingContactPojo.setEmail("pawel@nowak.pl");
        brandingContactPojo.setPhone("+48123456789");

        BrandingMapPojo brandingMapPojo = new BrandingMapPojo();
        brandingMapPojo.setLatitude(51.107883);
        brandingMapPojo.setLongitude(17.038538);

        brandingPojo.setName("New Branding from Pablo");
        brandingPojo.setDescription("Welcome in our website");
        brandingPojo.setLogoUrl("https://p.bookcdn.com/data/Photos/380x204/8900/890081/890081344/Center-Rooms-Villach-photos-Exterior-Center-Rooms-Villach.JPEG");
        brandingPojo.setBrandingContactPojo(brandingContactPojo);
        //brandingPojo.setMap(brandingMapPojo);



        given().header("Authorization", "Bearer " + token)
                .body(brandingPojo)
                .when().put("branding/")
                .then().statusCode(200);
    }
}

/*  2. zrobic test dodawania pokoju i pozniej pobierania listy a nastepnie sprawdzania czy pojawił sie na liscie*/
