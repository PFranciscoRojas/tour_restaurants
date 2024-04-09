package com.tour.restaurant.Domain.Repository;
import com.tour.restaurant.infraestructure.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<TableFood, Long> {

    // Método para buscar mesas disponibles que puedan acomodar al menos el número de personas especificado
    List<TableFood> findByCapacityGreaterThanEqualAndAvailableTrue(int numberOfPeople);

    // Aquí puedes agregar métodos adicionales si necesitas consultas personalizadas
}
