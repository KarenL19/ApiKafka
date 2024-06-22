package com.portal.cursoapi.service;

import com.portal.cursoapi.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {
    List<CarPostDTO> getCarForSales();
    void changeCarForSales(CarPostDTO carPostDTO, String id);
    void removeCarForSales(String id);
}
