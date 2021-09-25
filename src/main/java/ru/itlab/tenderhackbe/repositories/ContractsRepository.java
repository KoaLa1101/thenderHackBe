package ru.itlab.tenderhackbe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itlab.tenderhackbe.models.Contracts;

@Repository
public interface ContractsRepository extends JpaRepository<Contracts,Long> {
}
