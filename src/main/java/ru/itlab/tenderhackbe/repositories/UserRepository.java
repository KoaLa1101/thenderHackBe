package ru.itlab.tenderhackbe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itlab.tenderhackbe.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
