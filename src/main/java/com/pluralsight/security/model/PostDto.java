package com.pluralsight.security.model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private String queryId;
    private String content;
    private String username;
    private boolean resolve;

}
