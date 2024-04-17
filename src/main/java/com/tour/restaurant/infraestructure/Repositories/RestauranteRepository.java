package com.tour.restaurant.infraestructure.Repositories;
import com.tour.restaurant.Domain.Repository.RestaurantRepository;
import com.tour.restaurant.Domain.DTO.RestaurantDTO;
import com.tour.restaurant.infraestructure.Entities.Restaurant;
import com.tour.restaurant.infraestructure.Mapper.RestaurantMapper;
import com.tour.restaurant.infraestructure.Repositories.Crud.RestaurantCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class RestauranteRepository implements  RestaurantRepository{
    @Autowired
    public RestaurantCrudRepository restauranteRepo;
    @Autowired
    public RestaurantMapper mapper;
    //--------------------------------------------------------------------------------
    @Override
    public List<Restaurant> getAll(){
        List<Restaurant> restaurantes = (List<Restaurant>) restauranteRepo.findAll();
        return mapper.toRestaurants(restaurantes);
    }
    //--------------------------------------------------------------------------------
    @Override
    public List<Restaurant> getByRestaurant(Restaurant restaurant){
        List<Restaurant> restaurantes = (List<Restaurant>) restauranteRepo.getByRestaurant(restaurant);
        return mapper.toRestaurants(restaurantes);
    }
    //--------------------------------------------------------------------------------
    @Override
    public Optional<Restaurant> getById(long idRestaurant){
        Optional<Restaurant> restaurant = restauranteRepo.findById(idRestaurant);
        return mapper.toRestaurantsOptional(restaurant);
    }
    //--------------------------------------------------------------------------------
    @Override
    public Restaurant save(Restaurant restaurant){
        Restaurant restaurante = mapper.toRestaurant(restaurant);
        return mapper.toRestaurant(restauranteRepo.save(restaurante));
    }
    //--------------------------------------------------------------------------------
    @Override
    public void deleteByID(long idRestaurant){
        restauranteRepo.deleteById(idRestaurant);
    }
}
