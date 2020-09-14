package pojos.booking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingPojo {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDatesPojo bookingdates;
    private String additionalneeds;
    private int roomid;
    private String email;
    private String phone;

    @JsonProperty
    private String timestamp;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDatesPojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDatesPojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public int getRoomid() {
        return roomid;
    }

    public BookingPojo setRoomid(int roomid) {
        this.roomid = roomid;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BookingPojo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public BookingPojo setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
