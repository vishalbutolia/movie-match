package com.moviematch.rest.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Users")
public class User {
    private String firstName;
    private String lastName;
    private String password;
    @Indexed(unique = true)
    private String email;

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
}
