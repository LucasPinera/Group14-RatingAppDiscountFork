package com.rating.demo.controllers;

import com.rating.demo.beans.Rating;
import com.rating.demo.beans.Restaurant;
import com.rating.demo.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping ("/all")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/id/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/locations/{location}")
    public List<Restaurant> getRestaurantsByLocation(@PathVariable String location) {
        return restaurantService.getRestaurantsByLocation(location);
    }

    @GetMapping("/rating/{rating}")
    public List<Restaurant> getRestaurantsByMinRating(@PathVariable double rating) {
        return restaurantService.getRestaurantsByMinRating(rating);
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PostMapping("/{id}/rate")
    public Restaurant rateRestaurant(@PathVariable Long id, @RequestBody Rating rating) {
        return restaurantService.rateRestaurant(id, rating);
    }

}