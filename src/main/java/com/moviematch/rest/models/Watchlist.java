package com.moviematch.rest.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "UserWatchlist")
public class Watchlist {
    @Indexed
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId userId;
    @Indexed
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId movieId;
    private Date dateAdded;
    private Boolean status;
    @Id
    private String id;

    public Watchlist(ObjectId userId, ObjectId movieId, Boolean status) {
        this.userId = userId;
        this.movieId = movieId;
        this.status = status;
        this.dateAdded = new Date();
    }
}
