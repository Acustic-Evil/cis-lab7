package com.lab6.entity;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PathSegment {

    @NonNull
    private Long id;

    @JsonProperty("path_length") // Соответствие JSON ключу path_length
    private Long pathLength;

    @JsonProperty("path_name") // Соответствие JSON ключу path_name
    private String pathName;

    @JsonProperty("is_active") // Соответствие JSON ключу is_active
    private boolean isActive;
}

