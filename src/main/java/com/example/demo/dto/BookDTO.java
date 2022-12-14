package com.example.demo.dto;


import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {
    private long id;
    private String title;
    private String author;
    private String typeBook;
    private String description;
    private Date dateRelease;
    private int totalPage;
    private float price;
}
