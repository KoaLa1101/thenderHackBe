package ru.itlab.tenderhackbe.models;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

import java.math.BigDecimal;

@Data
@TypeDef(name = "json", typeClass = JsonType.class)
public class Order {
    private Long Id;
    private Double Quantity;
    private Double Amount;
}
