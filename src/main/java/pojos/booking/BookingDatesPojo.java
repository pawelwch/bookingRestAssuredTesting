package pojos.booking;

public class BookingDatesPojo {
    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public BookingDatesPojo setCheckin(String checkin) {
        this.checkin = checkin;
        return this;
    }

    public String getCheckout() {
        return checkout;
    }

    public BookingDatesPojo setCheckout(String checkout) {
        this.checkout = checkout;
        return this;
    }
}
