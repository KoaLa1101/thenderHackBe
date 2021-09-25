package ru.itlab.tenderhackbe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itlab.tenderhackbe.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
