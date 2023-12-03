package com.rating.demo.repositories;

import com.rating.demo.beans.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>
{
    List<Restaurant> findByLocation(String location);
    List<Restaurant> findByRatingGreaterThanEqualOrderByRatingAsc(double rating);
}
