package com.pluralsight.security.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;

@Getter
@ToString
@EqualsAndHashCode
public class Post {

    private final String username;
    private final String content;
    private final long timestamp;
    private String id;

    public Post(String username, String content, long timestamp) {
        this.username = username;
        this.content = content;
        this.timestamp = timestamp;
        this.id = new ObjectId().toHexString();
    }

}


