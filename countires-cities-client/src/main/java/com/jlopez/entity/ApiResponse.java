package com.jlopez.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public record ApiResponse<T>(List<T> data) {

}
