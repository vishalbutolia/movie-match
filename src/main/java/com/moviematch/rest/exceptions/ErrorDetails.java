package com.moviematch.rest.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetails {
    String message;
    Date date;

    public ErrorDetails(String message, Date date) {
        this.message = message;
        this.date = date;
    }
}
