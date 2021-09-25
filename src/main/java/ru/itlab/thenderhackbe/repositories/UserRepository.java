package ru.itlab.thenderhackbe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itlab.thenderhackbe.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
