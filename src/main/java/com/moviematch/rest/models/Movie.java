package com.moviematch.rest.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Movies")
public class Movie {
    private String title;
    private String plotKeywords;
    private Integer releaseYear;
    private Double aspectRatio;
    private Long facebookLikes;
    private List<String> actors;
    private List<String> directors;
    private Long usersVoteCount;
    private String imdbLink;
    private String contentRating;
    private Double imdbScore;
    private Double budget;
    private String country;
    private String language;
    private String genres;
    private Double gross;
    private Double duration;

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
}
