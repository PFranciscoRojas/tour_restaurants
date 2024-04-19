package com.tour.restaurant.Domain.Repository;


import org.springframework.stereotype.Repository;
import com.tour.restaurant.infraestructure.Entities.Booking;
import java.util.List;
import java.util.Optional;


@Repository
public interface BookingRepositoryDomain {

    List<Booking> findByBookingId(Long bookingId);
    List<Booking> getAll();
    List<Booking> getByBooking(Booking Booking);
    Optional<Booking> getById(long id);
    Booking save(Booking Booking);
    void deleteByID(long id);


}

