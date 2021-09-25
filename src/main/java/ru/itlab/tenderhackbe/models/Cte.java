package ru.itlab.tenderhackbe.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cte")
public class Cte {
    @Id
    private Long cteId;
    private String cteName;
    private String cteCategory;
    private String kpgzCode;
    private String characteristics;

}
