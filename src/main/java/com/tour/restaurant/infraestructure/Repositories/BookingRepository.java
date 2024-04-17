package com.tour.restaurant.infraestructure.Repositories;

import com.tour.restaurant.infraestructure.Entities.Booking;

import java.util.List;
import java.util.Optional;

public abstract class BookingRepository {

    public abstract Optional<Booking> findById(Long id);

    // Guardar una nueva reserva o actualizar una existente
    public abstract <S extends Booking> S save(S booking);

    // Recuperar todas las reservas
    public abstract List<Booking> findAll();
}
