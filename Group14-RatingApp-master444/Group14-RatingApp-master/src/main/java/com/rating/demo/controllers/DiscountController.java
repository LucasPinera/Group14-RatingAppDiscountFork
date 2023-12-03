package com.rating.demo.controllers;

import com.rating.demo.beans.Discount;
import com.rating.demo.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping("/all")
    public List<Discount> getAllDiscounts() {
        return discountService.getAllDiscounts();
    }

    @PostMapping("/add")
    public ResponseEntity<Discount> addDiscount(@RequestBody Discount discount) {
        Discount savedDiscount = discountService.addDiscount(discount);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDiscount);
    }

    // Endpoint to delete a discount
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDiscount(@PathVariable Integer id) {
        discountService.deleteDiscount(id);
        return ResponseEntity.status(HttpStatus.OK).body("Discount deleted successfully.");
    }

    // Endpoint to get discounts by restaurant ID
    @GetMapping("/restaurant/{restaurantId}")
    public List<Discount> getDiscountsByRestaurant(@PathVariable Integer restaurantId) {
        return discountService.getDiscountsByRestaurantRestaurantId(restaurantId);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Discount>> getDiscountsByLocation(@PathVariable String location) {
        List<Discount> discounts = discountService.getDiscountsByLocation(location);
        if (discounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(discounts, HttpStatus.OK);
    }


}


