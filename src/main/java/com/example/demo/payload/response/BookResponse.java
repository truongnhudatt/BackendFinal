package com.example.demo.payload.response;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookResponse {
    private long id;
    private String title;
    private String author;
    private String description;
    private String typeBook;
    private Date dateRelease;
    private int totalPage;
    private float price;
    private float rating;
}
