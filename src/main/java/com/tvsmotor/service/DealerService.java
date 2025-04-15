package com.tvsmotor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tvsmotor.entity.DealerData;
import com.tvsmotor.repository.DealerRepository;

import java.util.List;

@Service
public class DealerService {
    @Autowired
    private DealerRepository dealerMarkerRepository;

    public List<DealerData> getDealersByVehicle(String vehicleName) {
        return dealerMarkerRepository.findByVehiclesName(vehicleName);
    }

    public List<DealerData> getDealersByVehicleAndState(String vehicleName, String state) {
        return dealerMarkerRepository.findByVehiclesNameAndState(vehicleName, state);
    }

    public List<String> getDistinctStates() {
        List<DealerData> dealers = dealerMarkerRepository.findDistinctStates();
        return dealers.stream().map(DealerData::getState).distinct().toList();
    }
}

