package com.tour.restaurant.Domain.Repository;

import com.tour.restaurant.infraestructure.Entities.TableFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TableFoodRepositoryDomain  {



    Optional<TableFood> findByNumber(int number);


    List<TableFood> findByIsAvailableTrue();


    List<TableFood> findByIsAvailableFalse();

    List<TableFood> findAll();

    Optional<TableFood> findById(Long id);

    TableFood save(TableFood table);

    void deleteById(Long id);
}

