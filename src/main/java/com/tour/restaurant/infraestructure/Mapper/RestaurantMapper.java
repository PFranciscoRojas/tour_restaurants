package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.infraestructure.Entities.Restaurant;
import com.tour.restaurant.Domain.DTO.RestaurantDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    RestaurantDTO toDto(Restaurant restaurant);

    Restaurant toEntity(RestaurantDTO restaurantDTO);
}
