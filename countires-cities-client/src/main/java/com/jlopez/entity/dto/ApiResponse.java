package com.jlopez.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiResponse<T>(Boolean error, String msg,List<T> data) {

}
