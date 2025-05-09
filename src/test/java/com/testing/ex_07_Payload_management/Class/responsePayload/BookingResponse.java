package com.testing.ex_07_Payload_management.Class.responsePayload;

import com.testing.ex_07_Payload_management.Class.requestPayload.Booking;

public class BookingResponse {

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    private Integer bookingid;
    private Booking booking;

}
