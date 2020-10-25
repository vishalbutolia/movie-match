package com.moviematch.rest.repositories;

import com.moviematch.rest.models.Watchlist;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistRepository extends MongoRepository<Watchlist, String> {
    List<Watchlist> getAllByUserIdAndStatus(ObjectId userId, Boolean status);

    Watchlist getById(ObjectId id);

    Watchlist getByUserIdAndMovieId(ObjectId userId, ObjectId movieId);

    List<Watchlist> getAllByMovieIdInAndUserIdAndStatus(List<ObjectId> movieIds, ObjectId userId, Boolean status);
}
