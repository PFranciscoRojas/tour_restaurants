package com.tour.restaurant.Domain.Repository;
import com.tour.restaurant.infraestructure.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // Aquí puedes agregar métodos adicionales si necesitas consultas personalizadas
}
