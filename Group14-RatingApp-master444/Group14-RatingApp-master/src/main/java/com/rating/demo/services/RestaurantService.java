package com.rating.demo.services;
import com.rating.demo.beans.Rating;
import com.rating.demo.beans.Restaurant;


import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurantById(Long id);

    Restaurant getRestaurantById(Integer id);

    List<Restaurant> getRestaurantsByMinRating(double rating);
    List<Restaurant> getRestaurantsByLocation(String location);
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant rateRestaurant(Long restaurantId, Rating rating);

    Restaurant rateRestaurant(Integer restaurantId, Rating rating);
}
