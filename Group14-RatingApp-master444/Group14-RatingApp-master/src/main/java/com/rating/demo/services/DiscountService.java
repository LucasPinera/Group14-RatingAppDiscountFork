package com.rating.demo.services;

import com.rating.demo.beans.Discount;
import java.util.List;

public interface DiscountService {
    List<Discount> getAllDiscounts();
    Discount getDiscountById(Integer id);
    List<Discount> getDiscountsByRestaurantRestaurantId(Integer restaurantId);

    List<Discount> getDiscountsByLocation(String location);

    Discount addDiscount(Discount discount);
    Discount updateDiscount(Integer id, Discount updatedDiscount);
    void deleteDiscount(Integer id);
}


