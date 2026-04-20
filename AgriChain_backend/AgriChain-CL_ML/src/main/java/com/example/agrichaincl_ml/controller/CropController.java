package com.example.agrichaincl_ml.controller;

import com.example.agrichaincl_ml.entity.CropListing;
import com.example.agrichaincl_ml.entity.Order;
import com.example.agrichaincl_ml.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    // Farmer adds crop
    @PostMapping("/add")
    public CropListing addCrop(@RequestBody CropListing crop) {
        return cropService.addCropListing(crop);
    }

    // Get all crop listings
    @GetMapping("/all")
    public List<CropListing> getAllCrops() {
        return cropService.getAllCrops();
    }

    // Get crop listing by ID
    @GetMapping("/{id}")
    public CropListing getCropById(@PathVariable Long id) {
        return cropService.getCropById(id);
    }

    // Officer approves crop
    @PutMapping("/approve/{id}")
    public CropListing approveCrop(@PathVariable Long id) {
        return cropService.approveListing(id);
    }

    // Update crop listing
    @PutMapping("/update/{id}")
    public CropListing updateCrop(@PathVariable Long id, @RequestBody CropListing crop) {
        return cropService.updateCropListing(id, crop);
    }

    // Delete crop listing
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCrop(@PathVariable Long id) {
        cropService.deleteCropListing(id);
        return ResponseEntity.ok("Crop listing deleted successfully");
    }

    // Trader places order
    @PostMapping("/order")
    public Order placeOrder(@RequestBody Order order) {
        return cropService.placeOrder(order);
    }

    // Get all orders
    @GetMapping("/orders/all")
    public List<Order> getAllOrders() {
        return cropService.getAllOrders();
    }

    // Get order by ID
    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return cropService.getOrderById(id);
    }

    // Update order status
    @PutMapping("/orders/update/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return cropService.updateOrder(id, order);
    }

    // Delete order
    @DeleteMapping("/orders/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        cropService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully");
    }
}