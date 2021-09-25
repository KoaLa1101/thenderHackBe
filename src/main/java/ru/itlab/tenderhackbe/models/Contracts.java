package ru.itlab.tenderhackbe.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contracts")
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "contracts_number")
    private String contractsNumber;

    @Column(name = "publication_date")
    private String publicationDate;

    @Column(name = "transaction_date")
    private String transactionDate;

    @Column(name = "price")
    private String price;
    //ИНН заказчика
    private Long customerINN;
    //КПП заказчика
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

    @Column(name = "cte")
    private String STE;

}
