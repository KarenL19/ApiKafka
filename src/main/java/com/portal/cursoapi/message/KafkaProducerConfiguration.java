package com.portal.cursoapi.message;

import com.portal.cursoapi.dto.CarPostDTO;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}") //injetando valor a variavel bootstrapServer através do app.yml
    private String bootstrapServer;

    @Bean
    public ProducerFactory<String, CarPostDTO> userProducerFactory() { //o ProducerFactory produz o tipo de dado que irá ser trafegado (um map com chave e valor)


        Map<String, Object> confifProps = new HashMap<>(); //define o map para incluir as configuracoes do kafka

        confifProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer); // Informa o servidor a ser conectado
        confifProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS,false);//nao tera header
        confifProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());//
        confifProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());

        return new DefaultKafkaProducerFactory<>(confifProps);
    }

    @Bean
    public KafkaTemplate<String, CarPostDTO> userKafkaTemplate() {
        return new KafkaTemplate<>(userProducerFactory());
    }
}