package com.tvsmotor.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tvsmotor.entity.Order;
import com.tvsmotor.repository.OrderRepository;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> getOrdersByDealerId(String dealerId) {
        return orderRepository.findByDealerId(dealerId);
    }
}