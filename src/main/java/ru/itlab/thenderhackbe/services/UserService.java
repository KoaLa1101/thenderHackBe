package ru.itlab.thenderhackbe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itlab.thenderhackbe.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
