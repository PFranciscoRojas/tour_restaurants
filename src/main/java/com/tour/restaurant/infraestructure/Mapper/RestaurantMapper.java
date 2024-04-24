package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Entities.Restaurant;
import com.tour.restaurant.Domain.DTO.RestaurantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {RestaurantMapper.class})
public interface RestaurantMapper {
    @Mappings({
            @Mapping(source = "idRestaurante", target ="id"),
            @Mapping(source = "nombre", target ="name"),
            @Mapping(source = "descripcion", target ="description"),
            @Mapping(source = "direccion", target ="address"),
            @Mapping(source = "cronograma", target ="shedule"),
            @Mapping(source = "tipo", target ="type"),
            @Mapping(source = "creadoEn", target ="created_at"),
            @Mapping(source = "cargadoEn", target ="uploaded_at")
    })
    Restaurant toRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO toRestaurantDTO(Restaurant restaurant);
    List<RestaurantDTO> toRestaurants(List<Restaurant> restaurantes);
    /*default Optional<RestaurantDTO> toRestaurantsOptional(Optional<RestaurantDTO> restaurant ){
        return  restaurant.map(this::toRestaurantDTO);
    }*/
    @InheritInverseConfiguration
    Restaurant toRestaurante(Restaurant restaurant);
}
