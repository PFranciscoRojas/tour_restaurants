package com.tour.restaurant.Domain.Repository;
import com.tour.restaurant.infraestructure.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // Aquí puedes agregar métodos adicionales si necesitas consultas personalizadas
    List<Restaurant> getAll();
    List<Restaurant> getByRestaurant(Restaurant restaurant);
    Optional<Restaurant> getById(long id);
    void deleteByID(long id);
    //Restaurant save(Restaurant restaurant);
}
