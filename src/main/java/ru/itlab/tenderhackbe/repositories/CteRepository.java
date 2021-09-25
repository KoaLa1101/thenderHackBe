package ru.itlab.tenderhackbe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itlab.tenderhackbe.models.CTETableDTO;
import ru.itlab.tenderhackbe.models.Cte;

import java.util.List;

@Repository
public interface CteRepository extends JpaRepository<Cte,Long> {
    List<CTETableDTO> getAllByKpgzCode(String code);
}
