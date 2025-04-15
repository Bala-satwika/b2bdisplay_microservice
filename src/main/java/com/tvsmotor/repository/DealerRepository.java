package com.tvsmotor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tvsmotor.entity.DealerData;

import java.util.List;

public interface DealerRepository extends MongoRepository<DealerData, String> {
    List<DealerData> findByVehiclesName(String vehicleName);
    List<DealerData> findByVehiclesNameAndState(String vehicleName, String state);

    @Query(value = "{}", fields = "{state: 1}")
    List<DealerData> findDistinctStates();
}

