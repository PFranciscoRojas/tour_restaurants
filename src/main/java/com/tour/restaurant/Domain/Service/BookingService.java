package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Entities.Restaurant;
import com.tour.restaurant.Domain.Repository.BookingRepository;
import com.tour.restaurant.Domain.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public BookingDTO makeReservation(BookingDTO bookingDto) {

        Booking bookingEntity = convertToEntity(bookingDto);


        Restaurant restaurant = restaurantRepository.findById(bookingDto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("No se encontró ningún restaurante con el ID proporcionado: " + bookingDto.getRestaurantId()));


        bookingEntity.setRestaurant(restaurant);


        Booking savedBooking = bookingRepository.save(bookingEntity);


        return convertToDto(savedBooking);
    }


    private Booking convertToEntity(BookingDTO bookingDto) {
        Booking bookingEntity = new Booking();

        bookingEntity.setCapacity(bookingDto.getCapacity());
        bookingEntity.setDate(bookingDto.getDate());

        return bookingEntity;
    }


    private BookingDTO convertToDto(Booking bookingEntity) {
        BookingDTO bookingDto = new BookingDTO();

        bookingDto.setCapacity(bookingEntity.getCapacity());
        bookingDto.setDate(bookingEntity.getDate());

        return bookingDto;
    }
}
