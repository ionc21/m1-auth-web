package com.pluralsight.security.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;

@Document
@RequiredArgsConstructor
@Getter
@ToString
public class User {

    @NonNull
    private final String username;
    @Id
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @Email
    @NonNull
    private String email;
    @NonNull
    private String password;

}
