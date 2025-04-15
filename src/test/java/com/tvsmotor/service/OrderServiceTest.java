package com.tvsmotor.service;
import com.tvsmotor.entity.Order;
import com.tvsmotor.service.OrderService;
import com.tvsmotor.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    private Order order1;
    private Order order2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create sample Item instances
        Order.Item item1 = new Order.Item("Product1", 2, "Pending");
        Order.Item item2 = new Order.Item("Product2", 1, "Shipped");
        List<Order.Item> items1 = Arrays.asList(item1);
        List<Order.Item> items2 = Arrays.asList(item2);

        // Create sample Order instances
        order1 = new Order("1", "Order1", "Dealer1", items1, LocalDateTime.now());
        order2 = new Order("2", "Order2", "Dealer1", items2, LocalDateTime.now().minusDays(1));
    }

    @Test
    void testGetOrdersByDealerId() {
        // Arrange
        when(orderRepository.findByDealerId("Dealer1")).thenReturn(Arrays.asList(order1, order2));

        // Act
        List<Order> orders = orderService.getOrdersByDealerId("Dealer1");

        // Assert
        assertEquals(2, orders.size());
        assertEquals("Order1", orders.get(0).getOrderId());
        assertEquals("Order2", orders.get(1).getOrderId());
    }

    @Test
    void testGetOrdersByDealerId_NoOrders() {
        // Arrange
        when(orderRepository.findByDealerId("NonExistentDealer")).thenReturn(Collections.emptyList());

        // Act
        List<Order> orders = orderService.getOrdersByDealerId("NonExistentDealer");

        // Assert
        assertEquals(0, orders.size());
    }

    @Test
    void testGetOrdersByDealerId_SingleOrder() {
        // Arrange
        when(orderRepository.findByDealerId("Dealer1")).thenReturn(Collections.singletonList(order1));

        // Act
        List<Order> orders = orderService.getOrdersByDealerId("Dealer1");

        // Assert
        assertEquals(1, orders.size());
        assertEquals("Order1", orders.get(0).getOrderId());
    }
}
