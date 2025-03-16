package com.jlopez.util;

public enum Order {

    ASC("asc"),DESC("desc");

    final String description;

    Order(String description){
        this.description=description;
    }

}
