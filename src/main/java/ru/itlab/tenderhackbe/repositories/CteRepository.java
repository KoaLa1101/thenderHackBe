package ru.itlab.tenderhackbe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itlab.tenderhackbe.models.CTETableDTO;
import ru.itlab.tenderhackbe.models.Cte;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CteRepository extends JpaRepository<Cte,Long> {

    @Query(nativeQuery = true, value = "select * from cte where kpgz_code=:param1")
    List<Cte> getAllIdByKpgz(@Param("param1")String code);
}
