package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.Domain.Repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookingService {

    @Autowired
    private TableAssignmentService tableAssignmentService;

    @Autowired
    private BookingRepository bookingRepository;

    public BookingDTO makeReservation(BookingDTO bookingDto) {
        // Convertir el DTO de la reserva a la entidad de reserva
        Booking bookingEntity = convertToEntity(bookingDto);

        // Obtener la cantidad de personas en la reserva
        int numberOfPeople = bookingEntity.getNumberOfPeople();

        // Asignar una mesa para la reserva
        TableFood assignedTable = tableAssignmentService.assignTable(numberOfPeople);

        // Asignar la mesa a la reserva
        bookingEntity.setTableFood(assignedTable);

        // Guardar la reserva en la base de datos
        Booking savedBooking = bookingRepository.save(bookingEntity);

        // Convertir la entidad de reserva guardada a DTO y devolverla
        return convertToDto(savedBooking);
    }

    // Método para convertir un DTO de reserva a una entidad de reserva
    private Booking convertToEntity(BookingDTO bookingDto) {
        Booking bookingEntity = new Booking();
        // Asignar valores del DTO a la entidad
        bookingEntity.setNumberOfPeople(bookingDto.getNumberOfPeople());
        // Otros campos...
        return bookingEntity;
    }

    // Método para convertir una entidad de reserva a un DTO de reserva
    private BookingDTO convertToDto(Booking bookingEntity) {
        BookingDTO bookingDto = new BookingDTO();
        // Asignar valores de la entidad al DTO
        bookingDto.setNumberOfPeople(bookingEntity.getNumberOfPeople());
        // Otros campos...
        return bookingDto;
    }
}