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
        // Convertir el DTO de la reserva a la entidad de reserva
        Booking bookingEntity = convertToEntity(bookingDto);

        // Obtener el restaurante por su ID
        Restaurant restaurant = restaurantRepository.findById(bookingDto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("No se encontró ningún restaurante con el ID proporcionado: " + bookingDto.getRestaurantId()));

        // Asignar el restaurante a la reserva
        bookingEntity.setRestaurant(restaurant);

        // Guardar la reserva en la base de datos
        Booking savedBooking = bookingRepository.save(bookingEntity);

        // Convertir la entidad de reserva guardada a DTO y devolverla
        return convertToDto(savedBooking);
    }

    // Método para convertir un DTO de reserva a una entidad de reserva
    private Booking convertToEntity(BookingDTO bookingDto) {
        Booking bookingEntity = new Booking();
        // Asignar valores del DTO a la entidad
        bookingEntity.setCapacity(bookingDto.getCapacity());
        bookingEntity.setDate(bookingDto.getDate());
        // Otros campos...
        return bookingEntity;
    }

    // Método para convertir una entidad de reserva a un DTO de reserva
    private BookingDTO convertToDto(Booking bookingEntity) {
        BookingDTO bookingDto = new BookingDTO();
        // Asignar valores de la entidad al DTO
        bookingDto.setCapacity(bookingEntity.getCapacity());
        bookingDto.setDate(bookingEntity.getDate());
        // Otros campos...
        return bookingDto;
    }
}
