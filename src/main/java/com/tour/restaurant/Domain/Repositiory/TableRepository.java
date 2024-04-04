package com.tour.restaurant.Domain.Repositiory;
import com.tour.restaurant.infraestructure.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<TableFood, Long> {
    // Aquí puedes agregar métodos adicionales si necesitas consultas personalizadas
}
