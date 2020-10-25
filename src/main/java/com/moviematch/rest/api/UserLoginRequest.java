package com.moviematch.rest.api;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String email;
    private String password;
}
