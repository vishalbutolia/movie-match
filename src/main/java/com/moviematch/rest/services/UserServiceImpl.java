package com.moviematch.rest.services;

import com.moviematch.rest.api.UserLoginRequest;
import com.moviematch.rest.exceptions.AlreadyExistsException;
import com.moviematch.rest.exceptions.NotFoundException;
import com.moviematch.rest.models.User;
import com.moviematch.rest.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User createUser) {
        User user = userRepository.findByEmailAndPassword(createUser.getEmail(), createUser.getPassword());
        if (user != null) {
            throw new AlreadyExistsException("User already exists");
        }
        return userRepository.save(createUser);
    }

    @Override
    public User login(UserLoginRequest loginRequest) {
        User user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return user;
    }

    @Override
    public User getById(ObjectId id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }
}
