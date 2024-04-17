package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Repositories.BookingRepository;
import com.tour.restaurant.Domain.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, RestaurantRepository restaurantRepository) {
        this.bookingRepository = bookingRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public BookingDTO getBookingById(Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        return optionalBooking.map(this::convertToDTO).orElse(null);
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = convertToEntity(bookingDTO);
        // Additional logic for validation, setting default values, etc. can be added here
        Booking savedBooking = bookingRepository.save(booking);
        return convertToDTO(savedBooking);
    }

    private Booking convertToEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setCapacity(bookingDTO.getCapacity());
        // Set other fields similarly
        return booking;
    }

    private BookingDTO convertToDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        // Set other fields similarly
        return bookingDTO;
    }
}
