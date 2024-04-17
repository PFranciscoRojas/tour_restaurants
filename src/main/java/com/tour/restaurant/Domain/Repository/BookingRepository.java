package com.tour.restaurant.Domain.Repository;
import com.tour.restaurant.infraestructure.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Date;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRestaurantId(Long restaurantId);


}

