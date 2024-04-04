package com.tour.restaurant.infraestructure.Entities;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public enum BookingStatus {
        PENDING,
        CONFIRMED,
        CANCELED;

    @SpringBootApplication
    public static class RestaurantApplication {

        public static void main(String[] args) {
            SpringApplication.run(RestaurantApplication.class, args);
        }

    }
}


