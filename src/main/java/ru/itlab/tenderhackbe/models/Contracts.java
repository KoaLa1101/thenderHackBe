package ru.itlab.tenderhackbe.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Контракты")
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Номер контракта")
    private String contractsNumber;

    @Column(name = "Дата Публикации КС на ПП")
    private String publicationDate;

    @Column(name = "Дата заключения контракта")
    private String transactionDate;

    @Column(name = "Цена контракта")
    private String price;
    //ИНН заказчика
    private Long customerINN;
    //КПП заказчика
    private Long customerKPP;

    @Column(name = "Наименование Заказчика")
    private String customerName;

    //ИНН поставщика
    @Column(name = "ИНН поставщика")
    private Long sellerINN;
    //КПП поставщика
    @Column(name = "КПП поставщика")
    private Long sellerKPP;

    @Column(name = "Наименование поставщика")
    private String sellerName;

    @Column(name = "СТЕ")
    private String STE;

}
