package com.tour.restaurant.Domain.DTO;

import java.util.Date;

public class BookingDTO {

    private Long id;
    private Integer capacity;
    private Date date;
    private Long restaurantId;


    public Integer getNumberOfPeople() {
        return 0;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
    }
}
