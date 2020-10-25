package com.moviematch.rest.services;

import com.moviematch.rest.api.AddToWatchlist;
import com.moviematch.rest.models.Watchlist;
import org.bson.types.ObjectId;

import java.util.List;

public interface WatchlistService {
    Watchlist addToWatchlist(AddToWatchlist addToWatchlist);

    List<Watchlist> getUserWatchlist(ObjectId userId);

    Watchlist removeFromWatchlist(ObjectId watchlistId);

    List<Watchlist> getCommonWatchlistBetweenUsers(ObjectId primaryUserId, ObjectId secondaryUserId);
}
