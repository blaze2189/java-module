package com.jlopez.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StateDTO(String name,
                       @JsonProperty("state_code") String stateCode) {
}
