package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.infraestructure.Entities.Restaurant;
import com.tour.restaurant.Domain.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Obtener todos los restaurantes
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    // Obtener un restaurante por su ID
    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    // Guardar un restaurante
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Actualizar un restaurante
    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        // Verificar si el restaurante existe
        Optional<Restaurant> existingRestaurantOptional = restaurantRepository.findById(id);
        if (existingRestaurantOptional.isPresent()) {
            // Establecer el ID del restaurante actualizado
            updatedRestaurant.setId(id);
            // Guardar el restaurante actualizado
            return restaurantRepository.save(updatedRestaurant);
        } else {
            // El restaurante no existe
            throw new IllegalArgumentException("El restaurante con ID " + id + " no existe.");
        }
    }

    // Eliminar un restaurante por su ID
    public void deleteRestaurantById(Long id) {
        // Verificar si el restaurante existe
        if (restaurantRepository.existsById(id)) {
            restaurantRepository.deleteById(id);
        } else {
            // El restaurante no existe
            throw new IllegalArgumentException("El restaurante con ID " + id + " no existe.");
        }
    }
}
