package com.portal.cursoapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.apache.kafka.common.protocol.types.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude
public class OwnerPostDTO {
    private String name;
    private String type;
    private String contactNumber;
}
