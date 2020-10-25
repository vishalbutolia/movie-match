package com.moviematch.rest.services;

import com.moviematch.rest.exceptions.NotFoundException;
import com.moviematch.rest.models.Movie;
import com.moviematch.rest.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie getById(ObjectId id) {
        return movieRepository.findById(id).orElseThrow(() -> new NotFoundException("Movie not found"));
    }
}
