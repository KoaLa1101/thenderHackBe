package ru.itlab.tenderhackbe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "contracts")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Contracts {
    @Id
    @Column(name = "contracts_number")
    private String contractsNumber;

    @Column(name = "publication_date")
    private String publicationDate;

    @Column(name = "transaction_date")
    private String transactionDate;

    @Column(name = "price")
    private String price;
    //ИНН заказчика
    @Column(name = "customer_inn")
    private Long customerINN;
    //КПП заказчика
    @Column(name = "customer_kpp")
    private Long customerKPP;

    @Column(name = "customer_name")
    private String customerName;

    //ИНН поставщика
    @Column(name = "seller_inn")
    private Long sellerINN;
    //КПП поставщика
    @Column(name = "seller_kpp")
    private Long sellerKPP;

    @Column(name = "seller_name")
    private String sellerName;

    @JsonProperty("Order")
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Order cte;



}
