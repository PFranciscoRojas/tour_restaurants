package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TableFoodMapper {

    TableFoodDTO toDto(TableFood tableFood);

    TableFood toEntity(TableFoodDTO tableFoodDTO);
}
