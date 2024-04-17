package com.tour.restaurant.infraestructure.Repositories.Crud;

import com.tour.restaurant.infraestructure.Entities.TableFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TableFoodCrudRepository extends JpaRepository<TableFood, Long> {


    List<TableFood> findByCapacityGreaterThanEqualAndIsAvailableTrue(int capacity);

    Optional<TableFood> findByNumber(int number);


    List<TableFood> findByIsAvailableTrue();


    List<TableFood> findByIsAvailableFalse();
}