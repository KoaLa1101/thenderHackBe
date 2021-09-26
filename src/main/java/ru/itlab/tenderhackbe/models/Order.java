package ru.itlab.tenderhackbe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

import java.math.BigDecimal;

@Data
@TypeDef(name = "json", typeClass = JsonType.class)
public class Order {
    @JsonProperty("Id")
    private Long Id;
    @JsonProperty("Quantity")
    private Double Quantity;
    @JsonProperty("Amount")
    private Double Amount;
}
