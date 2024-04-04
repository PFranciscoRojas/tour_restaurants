package com.restaurant.main.Domain.Repositiory;
import com.restaurant.main.infraestructure.Entities.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
    // Aquí puedes agregar métodos adicionales si necesitas consultas personalizadas
}
