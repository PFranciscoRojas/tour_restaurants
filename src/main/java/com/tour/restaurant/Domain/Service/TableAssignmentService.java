package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.Domain.Repository.TableRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TableAssignmentService {

    @Autowired
    private TableRepository tableRepository;

    public TableFood assignTable(int numberOfPeople) {
        // Buscar mesas disponibles que puedan acomodar al menos numberOfPeople
        List<TableFood> availableTables = tableRepository.findByCapacityGreaterThanEqualAndAvailableTrue(numberOfPeople);

        // Si no hay mesas disponibles, lanzar una excepción
        if (availableTables.isEmpty()) {
            throw new RuntimeException("No hay mesas disponibles para acomodar " + numberOfPeople + " personas.");
        }

        // Devolver la primera mesa disponible que pueda acomodar al menos numberOfPeople
        return availableTables.get(0);
    }
}
