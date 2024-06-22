package com.portal.cursoapi.client;

import com.portal.cursoapi.dto.CarPostDTO;
import com.portal.cursoapi.dto.OwnerPostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(
        name = "car-server-sales",
        url = "http://localhost:8080/server",
       decode404 = true
)

@Component
public interface CarPostStoreClient {

    @GetMapping(value = "/cars")
    List<CarPostDTO> getCarForSalesClient();

    @PostMapping(value = "/user")
    void ownerPostClient(@RequestBody OwnerPostDTO newUser);

    @PutMapping(value = "/car/{id}")
    void changeCarForSaleClient(@RequestBody CarPostDTO car, @PathVariable String id);

    @DeleteMapping(value = "/car/{id}")
    void deleteCarForSaleClient(@PathVariable String id);



}
