package com.tvsmotor.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tvsmotor.entity.DealerData;
import com.tvsmotor.entity.Order;
import com.tvsmotor.service.DealerService;
import com.tvsmotor.service.OrderService;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/dealers")
public class DealerController {
    @Autowired
    private DealerService dealerMarkerService;
    @Autowired
    private OrderService orderService;
    @GetMapping("/filter")
    public List<DealerData> getDealersByVehicleAndState(
            @RequestParam("vehicle") String vehicle,
            @RequestParam(value = "state", required = false) String state) {
        if (state == null || state.isEmpty()) {
            return dealerMarkerService.getDealersByVehicle(vehicle);
        } else {
            return dealerMarkerService.getDealersByVehicleAndState(vehicle, state);
        }
    }
    @GetMapping("/states")
    public List<String> getDistinctStates() {
        return dealerMarkerService.getDistinctStates();
    }
    @GetMapping("/orders")
    public List<Order> getOrdersByDealerId(@RequestParam String dealerId) {
        return orderService.getOrdersByDealerId(dealerId);
    }
}