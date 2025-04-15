package com.tvsmotor.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.tvsmotor.entity.Order;
import java.util.List;
public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByDealerId(String dealerId);
}