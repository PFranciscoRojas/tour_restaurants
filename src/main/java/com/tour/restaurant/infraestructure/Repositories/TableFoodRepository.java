package com.tour.restaurant.infraestructure.Repositories;


import com.tour.restaurant.Domain.Repository.TableFoodRepositoryDomain;
import com.tour.restaurant.infraestructure.Entities.TableFood;

import java.util.List;
import java.util.Optional;

public class TableFoodRepository implements TableFoodRepositoryDomain{



    @Override
    public Optional<TableFood> findByNumber(int number) {
        return Optional.empty();
    }

    @Override
    public List<TableFood> findByIsAvailableTrue() {
        return null;
    }

    @Override
    public List<TableFood> findByIsAvailableFalse() {
        return null;
    }

    @Override
    public List<TableFood> findAll() {
        return null;
    }

    @Override
    public Optional<TableFood> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public TableFood save(TableFood table) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
