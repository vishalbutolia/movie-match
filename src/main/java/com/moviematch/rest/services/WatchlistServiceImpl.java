package com.moviematch.rest.services;

import com.moviematch.rest.api.AddToWatchlist;
import com.moviematch.rest.models.Watchlist;
import com.moviematch.rest.repositories.WatchlistRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    @Autowired
    MovieService movieService;

    @Autowired
    WatchlistRepository watchlistRepository;


    @Override
    public Watchlist addToWatchlist(AddToWatchlist addToWatchlist) {
        Watchlist watchlist = watchlistRepository.getByUserIdAndMovieId(addToWatchlist.getUserId(), addToWatchlist.getMovieId());
        if (watchlist != null) {
            watchlist.setStatus(Boolean.TRUE);
        } else {
            watchlist = new Watchlist(addToWatchlist.getUserId(), addToWatchlist.getMovieId(), addToWatchlist.getStatus());
        }
        return watchlistRepository.save(watchlist);
    }

    @Override
    public List<Watchlist> getUserWatchlist(ObjectId userId) {
        return watchlistRepository.getAllByUserIdAndStatus(userId, Boolean.TRUE);
    }

    @Override
    public Watchlist removeFromWatchlist(ObjectId watchlistId) {
        Watchlist watchlist = watchlistRepository.getById(watchlistId);
        watchlist.setStatus(Boolean.FALSE);
        return watchlistRepository.save(watchlist);
    }

    public List<Watchlist> getCommonWatchlistBetweenUsers(ObjectId primaryUserId, ObjectId secondaryUserId) {
        final List<Watchlist> primaryUserWatchlist = watchlistRepository.getAllByUserIdAndStatus(primaryUserId, Boolean.TRUE);
        List<ObjectId> movieIds = primaryUserWatchlist.stream().
                map(watchlist -> watchlist.getMovieId()).
                collect(Collectors.toList());

        return watchlistRepository.getAllByMovieIdInAndUserIdAndStatus(movieIds, secondaryUserId, Boolean.TRUE);
    }
}
