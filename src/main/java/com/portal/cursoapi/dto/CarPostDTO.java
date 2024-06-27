package com.portal.cursoapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.apache.kafka.common.protocol.types.Field;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude
public class CarPostDTO { //Data Transfer Object

    private String model;
    private String brand;
    private Double price;
    private String description;
    private String engineVersion;
    private String city;
    private String createdDate;
    private Long ownerId;
    private String ownerName;
    private String ownerType;
    private String contact;
}
