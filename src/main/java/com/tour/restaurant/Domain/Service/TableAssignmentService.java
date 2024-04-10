package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.Domain.Repository.TableRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TableAssignmentService {

    @Autowired
    private TableRepository tableRepository;

    public TableFoodDTO assignTable(int numberOfPeople) {

        List<TableFood> availableTables = tableRepository.findByCapacityGreaterThanEqualAndAvailableTrue(numberOfPeople);


        if (availableTables.isEmpty()) {
            throw new RuntimeException("No hay mesas disponibles para acomodar " + numberOfPeople + " personas.");
        }


        return convertToDto(availableTables.get(0));
    }


    private TableFoodDTO convertToDto(TableFood tableEntity) {
        TableFoodDTO tableDto = new TableFoodDTO();

        tableDto.setId(tableEntity.getId());
        tableDto.setCapacity(tableEntity.getCapacity());
        tableDto.setNumber(tableEntity.getNumber());
        tableDto.setAvailable(tableEntity.getAvailable());
        return tableDto;
    }
}
