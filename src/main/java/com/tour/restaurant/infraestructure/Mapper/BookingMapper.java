package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.Domain.DTO.BookingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface BookingMapper {

    @Mapping(target = "restaurantId", source = "restaurant.id")
    BookingDTO toDto(Booking booking);

    @Mapping(target = "restaurant.id", source = "restaurantId")
    Booking toEntity(BookingDTO bookingDTO);
}
