package com.rating.demo.services.impl;

import com.rating.demo.beans.Restaurant;
import com.rating.demo.services.RestaurantService;
import com.rating.demo.repositories.RestaurantRepository;
import com.rating.demo.beans.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService
{
    RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository)
    {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants()
    {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return null;
    }

    @Override
    public Restaurant getRestaurantById(Integer id) {
        return restaurantRepository.findById(id).orElse(null);
    }
    @Override
    public List<Restaurant> getRestaurantsByMinRating(double rating) {
        return restaurantRepository.findByRatingGreaterThanEqualOrderByRatingAsc(rating);
    }

    @Override
    public List<Restaurant> getRestaurantsByLocation(String location) {
        return restaurantRepository.findByLocation(location);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant)
    {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant rateRestaurant(Long restaurantId, Rating rating) {
        return null;
    }


    @Override
    public Restaurant rateRestaurant(Integer restaurantId, Rating rating) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        if (restaurant != null) {
            rating.setRestaurant(restaurant);
            restaurant.getRatings().add(rating);

            // Update the average rating for the restaurant
            double averageRating = calculateAverageRating(restaurant);
            restaurant.setRating(averageRating);

            return restaurantRepository.save(restaurant);
        }

        return null; // or handle the case where the restaurant is not found
    }

    private double calculateAverageRating(Restaurant restaurant) {
        List<Rating> ratings = restaurant.getRatings();
        if (ratings.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Rating r : ratings) {
            sum += r.getRatings(); // Fix the method to use getRating() instead of getRatings()
        }

        return (double) sum / ratings.size();
    }

}
