package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.Domain.Repository.TableFoodRepositoryDomain;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class TableFoodService {

    @Autowired
    private TableFoodRepositoryDomain tableFoodRepositoryDomain;


    public TableFoodDTO assignTable(int numberOfPeople) {
        List<TableFood> availableTables = tableFoodRepositoryDomain.findByCapacityGreaterThanEqualAndIsAvailableTrue(numberOfPeople);

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
        tableDto.setAvailable(tableEntity.isAvailable());

        return tableDto;
    }


    public List<TableFood> getAllTables() {
        return tableFoodRepositoryDomain.findAll();
    }


    public Optional<TableFood> getTableById(Long id) {
        return tableFoodRepositoryDomain.findById(id);
    }


    public TableFood saveTable(TableFood table) {
        return tableFoodRepositoryDomain.save(table);
    }


    public void deleteTableById(Long id) {
        tableFoodRepositoryDomain.deleteById(id);
    }

    public void updateTableAvailability(Long id, boolean available) {
        Optional<TableFood> tableOptional = tableFoodRepositoryDomain.findById(id);
        if (tableOptional.isPresent()) {
            TableFood table = tableOptional.get();
            table.setAvailable(available);
            tableFoodRepositoryDomain.save(table);
        } else {
            throw new RuntimeException("No se encontró la mesa con ID: " + id);
        }
    }
}
