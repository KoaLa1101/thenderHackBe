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


    @Query(nativeQuery = true,value = "select * from contracts where cte->> 'id' =:cteId ")
    List<Contracts> findByCteId(@Param("cteId") Long cteId);

}
