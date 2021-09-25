package ru.itlab.tenderhackbe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itlab.tenderhackbe.models.Cte;

public interface CteRepository extends JpaRepository<Cte,Long> {
}
