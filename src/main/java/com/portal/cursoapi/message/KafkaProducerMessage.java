package com.portal.cursoapi.message;

import com.portal.cursoapi.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {
    @Autowired
    private KafkaTemplate<String, CarPostDTO> kafkaTemplate;

    private final String TOPIC_CAR_POST = "car_post_topic";

    public void sendMessage(CarPostDTO carPostDTO) {
        kafkaTemplate.send(TOPIC_CAR_POST, carPostDTO);
    }
}
