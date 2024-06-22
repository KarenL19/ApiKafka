package com.portal.cursoapi.controller;

import com.portal.cursoapi.dto.CarPostDTO;
import com.portal.cursoapi.message.KafkaProducerMessage;
import com.portal.cursoapi.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car-manager")
public class CarPostController {
    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;


    @PostMapping("/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDTO carPostDTO) {
        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSales(@PathVariable String id, @RequestBody CarPostDTO carPostDTO){
        carPostStoreService.changeCarForSales(carPostDTO,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarSales(@PathVariable String id){
        carPostStoreService.removeCarForSales(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
