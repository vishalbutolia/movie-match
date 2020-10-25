package com.moviematch.rest.api;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class AddToWatchlist {
    final Boolean status = Boolean.TRUE;
    ObjectId userId;
    ObjectId movieId;
}
