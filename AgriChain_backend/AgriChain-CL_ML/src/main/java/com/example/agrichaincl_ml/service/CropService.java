package com.example.agrichaincl_ml.service;

import com.example.agrichaincl_ml.entity.CropListing;
import com.example.agrichaincl_ml.entity.Order;
import com.example.agrichaincl_ml.repository.CropListingRepository;
import com.example.agrichaincl_ml.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService {

    @Autowired
    private CropListingRepository cropRepo;

    @Autowired
    private OrderRepository orderRepo;

    // Farmer adds crop listing
    public CropListing addCropListing(CropListing crop) {
        crop.setStatus("Pending");
        return cropRepo.save(crop);
    }

    // Get all crop listings
    public List<CropListing> getAllCrops() {
        return cropRepo.findAll();
    }

    // Get crop by ID
    public CropListing getCropById(Long id) {
        return cropRepo.findById(id).orElseThrow();
    }

    // Officer approves crop listing
    public CropListing approveListing(Long listingId) {
        CropListing crop = cropRepo.findById(listingId).orElseThrow();
        crop.setStatus("Approved");
        return cropRepo.save(crop);
    }

    // Update crop listing
    public CropListing updateCropListing(Long id, CropListing updated) {
        CropListing crop = cropRepo.findById(id).orElseThrow();
        crop.setCropType(updated.getCropType());
        crop.setQuantity(updated.getQuantity());
        crop.setPrice(updated.getPrice());
        crop.setLocation(updated.getLocation());
        crop.setStatus(updated.getStatus());
        return cropRepo.save(crop);
    }

    // Delete crop listing
    public void deleteCropListing(Long id) {
        cropRepo.deleteById(id);
    }

    // Trader places order
    public Order placeOrder(Order order) {
        order.setStatus("Placed");
        return orderRepo.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    // Get order by ID
    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElseThrow();
    }

    // Update order
    public Order updateOrder(Long id, Order updated) {
        Order order = orderRepo.findById(id).orElseThrow();
        order.setQuantity(updated.getQuantity());
        order.setStatus(updated.getStatus());
        return orderRepo.save(order);
    }

    // Delete order
    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }
}