package com.moviematch.rest.repositories;

import com.moviematch.rest.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
