package com.moviematch.rest.services;

import com.moviematch.rest.models.Movie;
import org.bson.types.ObjectId;

public interface MovieService {
    Movie getById(ObjectId id);
}
