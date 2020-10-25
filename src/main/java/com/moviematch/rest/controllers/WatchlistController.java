package com.moviematch.rest.controllers;

import com.moviematch.rest.api.AddToWatchlist;
import com.moviematch.rest.models.Watchlist;
import com.moviematch.rest.services.WatchlistService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    @Autowired
    WatchlistService watchlistService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Watchlist addToWatchlist(@RequestBody AddToWatchlist addToWatchlist) {
        return watchlistService.addToWatchlist(addToWatchlist);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Watchlist> getWatchlist(@PathVariable ObjectId userId) {
        return watchlistService.getUserWatchlist(userId);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Watchlist deleteFromWatchlist(@PathVariable ObjectId id) {
        return watchlistService.removeFromWatchlist(id);
    }

    @GetMapping(value = "/commonWatchlist/{primaryUserId}/{secondaryUserId}")
    public List<Watchlist> getCommonWatchlist(@PathVariable ObjectId primaryUserId, @PathVariable ObjectId secondaryUserId) {
        return watchlistService.getCommonWatchlistBetweenUsers(primaryUserId, secondaryUserId);
    }

}
