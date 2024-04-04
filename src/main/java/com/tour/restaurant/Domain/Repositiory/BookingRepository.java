package com.restaurant.main.Domain.Repositiory;
import com.restaurant.main.infraestructure.Entities.Booking;
import com.restaurant.main.infraestructure.Entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Date;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> getAll();
    List<Booking> getByRestaurant(Restaurant restaurant);
    Optional<Booking> getById(long idBook);

    Booking save(Booking booking);
    void delete(long idBook);

    // Obtener todas las reservaciones
    List<Booking> findAll();

    // Obtener una reserva por su ID
    Optional<Booking> findById(Long id);

    // Obtener todas las reservaciones de un restaurante específico
    List<Booking> findByRestaurante(Restaurant restaurante);

    // Eliminar una reserva
    void delete(Booking reservacion);

    // Actualizar el estado activo de una reserva
    void updateActiveStatus(Long id, boolean active);

    // Actualizar el estado desactivado de una reserva
    void updateDeactivateStatus(Long id, boolean deactivated);

    // Obtener todas las reservaciones con estado activo
    List<Booking> findByStatusTrue();

    // Obtener todas las reservaciones con estado desactivado
    List<Booking> findByStatusFalse();

    // Obtener todas las reservaciones para un día específico
    List<Booking> findByDate(Date date);

    // Obtener todas las reservaciones para una semana específica
    List<Booking> findByDateBetween(Date startDate, Date endDate);

    // Obtener todas las reservaciones para un mes específico
    List<Booking> findByDateWeekBetween(Date startMonth, Date endMonth);
}


