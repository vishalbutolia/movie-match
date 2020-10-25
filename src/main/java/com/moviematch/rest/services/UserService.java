package com.moviematch.rest.services;

import com.moviematch.rest.api.UserLoginRequest;
import com.moviematch.rest.models.User;
import org.bson.types.ObjectId;

public interface UserService {
    User createUser(User newUser);

    User login(UserLoginRequest loginRequest);

    User getById(ObjectId id);
}
