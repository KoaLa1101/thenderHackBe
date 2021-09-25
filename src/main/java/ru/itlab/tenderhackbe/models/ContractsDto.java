package ru.itlab.tenderhackbe.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Subselect;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractsDto {

    private String id;
    private String Quantity;

    private String sellerName;



}
