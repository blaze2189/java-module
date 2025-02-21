package com.jlopez.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiResponse<T>(Boolean error, String msg,List<T> data) {

}
