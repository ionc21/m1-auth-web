package com.pluralsight.security.model;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class CreateSupportQueryDto {

    private String subject;
    private String content;
    private boolean resolved;

}
