package ru.itlab.tenderhackbe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itlab.tenderhackbe.models.Contracts;
import ru.itlab.tenderhackbe.models.ContractsDto;

import java.util.List;

@Repository
public interface ContractsRepository extends JpaRepository<Contracts,Long> {


    @Query(nativeQuery = true,value = "select contracts_number,publication_date,transaction_date,price,customer_inn,customer_kpp,customer_name,seller_inn,seller_kpp,contracts.seller_name,jso as cte from contracts,(select json_array_elements(cte) as jso from contracts) as jsn where row_to_json(jsn)->'jso'->>'Id'=:cteId")
    List<Contracts> findByCteId(@Param("cteId") String cteId);

}
