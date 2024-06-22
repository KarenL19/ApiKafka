package com.portal.cursoapi.service.ServiceImpl;

import com.portal.cursoapi.client.CarPostStoreClient;
import com.portal.cursoapi.dto.CarPostDTO;
import com.portal.cursoapi.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    @Autowired
    private CarPostStoreClient cartPostStoreClient;


    @Override
    public List<CarPostDTO> getCarForSales() {
        return cartPostStoreClient.getCarForSalesClient();
    }

    @Override
    public void changeCarForSales(CarPostDTO carPostDTO, String id) {
        cartPostStoreClient.changeCarForSaleClient(carPostDTO,id);

    }

    @Override
    public void removeCarForSales(String id) {
        cartPostStoreClient.deleteCarForSaleClient(id);

    }
}
