package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {TableFoodMapper.class})
public interface TableFoodMapper {

    @Mappings({
            @Mapping(source = "idMesa", target ="id"),
            @Mapping(source = "capacidad", target ="capacity"),
            @Mapping(source = "descripcion", target ="number"),
            @Mapping(source = "direccion", target ="isAvailable"),
            @Mapping(source = "cronograma", target ="createdAt"),
            @Mapping(source = "tipo", target ="updatedAt")
    })
    TableFood toTableFood(TableFood tableFood);
    List<TableFood> toTablesFood(List<TableFood> tableFoods);
    default Optional<TableFood> toTablesFoodOptional(Optional<TableFood> tableFood ){
        return  tableFood.map(this::toTableFood);
    }
    /*@InheritInverseConfiguration
    TableFood toTableFood(TableFood restaurant);*/
}

