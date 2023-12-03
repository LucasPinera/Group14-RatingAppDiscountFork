package com.rating.demo.repositories;

import com.rating.demo.beans.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    List<Discount> findByRestaurantRestaurantId(Integer restaurantId);

    List<Discount> findByLocation(String location); // Add this method to find discounts by location

    void deleteById(Integer id); // Ensure consistency in using Integer
    // Additional query methods if needed...
}

