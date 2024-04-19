package com.tour.restaurant.infraestructure.Repositories;

import com.tour.restaurant.Domain.Repository.BookingRepositoryDomain;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Mapper.BookingMapper;
import com.tour.restaurant.infraestructure.Repositories.Crud.BookingCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public  class BookingRepository implements BookingRepositoryDomain {

    @Autowired
    private BookingCrudRepository bookingCrudRepository;

    @Autowired
    private BookingMapper bookingMapper;


    @Override
    public List<Booking> findByBookingId(Long bookingId) {
        return null;
    }

    @Override
    public List<Booking> getAll() {
        return null;
    }


    @Override
    public List<Booking> getByBooking(Booking Booking) {
        return null;
    }

    @Override
    public Optional<Booking> getById(long id) {
        return Optional.empty();
    }

    @Override
    public Booking save(Booking Booking) {
        return null;
    }

    @Override
    public void deleteByID(long id) {

    }

}
