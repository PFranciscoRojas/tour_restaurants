package com.restaurant.main.Domain.Repositiory;
import com.restaurant.main.infraestructure.Entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // Aquí puedes agregar métodos adicionales si necesitas consultas personalizadas
}
