package com.tvsmotor.service;

import com.tvsmotor.entity.DealerData;
import com.tvsmotor.service.DealerService;
import com.tvsmotor.repository.DealerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DealerServiceTest {

    @InjectMocks
    private DealerService dealerService;

    @Mock
    private DealerRepository dealerRepository;

    private DealerData dealer1;
    private DealerData dealer2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create sample Vehicle instances
        DealerData.Vehicle vehicle1 = new DealerData.Vehicle("Vehicle1", 10);
        DealerData.Vehicle vehicle2 = new DealerData.Vehicle("Vehicle2", 5);
        List<DealerData.Vehicle> vehicles = Arrays.asList(vehicle1, vehicle2);

        // Create sample DealerData instances
        dealer1 = new DealerData("1", "Dealer 1", "Address 1", "123456", 12.34, 56.78, 4.5, 
                                 "9 AM - 6 PM", "Category 1", "1234567890", 
                                 "www.dealer1.com", "Open", "photoUrl1", 
                                 "State1", Arrays.asList("sales"), vehicles, "dealerId1", "stateId1");

        dealer2 = new DealerData("2", "Dealer 2", "Address 2", "654321", 23.45, 67.89, 4.0, 
                                 "10 AM - 5 PM", "Category 2", "0987654321", 
                                 "www.dealer2.com", "Open", "photoUrl2", 
                                 "State2", Arrays.asList("service"), Collections.emptyList(), "dealerId2", "stateId2");
    }

    @Test
    void testGetDealersByVehicle() {
        // Arrange
        when(dealerRepository.findByVehiclesName("Vehicle1")).thenReturn(Arrays.asList(dealer1));

        // Act
        List<DealerData> dealers = dealerService.getDealersByVehicle("Vehicle1");

        // Assert
        assertEquals(1, dealers.size());
        assertEquals("Dealer 1", dealers.get(0).getName());
    }

    @Test
    void testGetDealersByVehicleAndState() {
        // Arrange
        when(dealerRepository.findByVehiclesNameAndState("Vehicle1", "State1")).thenReturn(Arrays.asList(dealer1));

        // Act
        List<DealerData> dealers = dealerService.getDealersByVehicleAndState("Vehicle1", "State1");

        // Assert
        assertEquals(1, dealers.size());
        assertEquals("Dealer 1", dealers.get(0).getName());
    }

    @Test
    void testGetDealersByVehicleAndState_NoMatch() {
        // Arrange
        when(dealerRepository.findByVehiclesNameAndState("Vehicle1", "State2")).thenReturn(Collections.emptyList());

        // Act
        List<DealerData> dealers = dealerService.getDealersByVehicleAndState("Vehicle1", "State2");

        // Assert
        assertEquals(0, dealers.size());
    }

    @Test
    void testGetDistinctStates() {
        // Arrange
        when(dealerRepository.findDistinctStates()).thenReturn(Arrays.asList(dealer1, dealer2));

        // Act
        List<String> states = dealerService.getDistinctStates();

        // Assert
        assertEquals(2, states.size());
        assertEquals("State1", states.get(0));
        assertEquals("State2", states.get(1));
    }

    @Test
    void testGetDistinctStates_NoDealers() {
        // Arrange
        when(dealerRepository.findDistinctStates()).thenReturn(Collections.emptyList());

        // Act
        List<String> states = dealerService.getDistinctStates();

        // Assert
        assertEquals(0, states.size());
    }

    @Test
    void testGetDealersByVehicle_NoDealers() {
        // Arrange
        when(dealerRepository.findByVehiclesName("NonExistentVehicle")).thenReturn(Collections.emptyList());

        // Act
        List<DealerData> dealers = dealerService.getDealersByVehicle("NonExistentVehicle");

        // Assert
        assertEquals(0, dealers.size());
    }
}
