package com.uwjx.retrofittesting.model;

import lombok.Data;

@Data
public class Book {

    private Long id;

    private String name;

    private String author;

    private Double price;
}
