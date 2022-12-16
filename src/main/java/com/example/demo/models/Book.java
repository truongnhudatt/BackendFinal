package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String author;
    @Column(length = 500)
    private String description;
    private String typeBook;
    private Date dateRelease;
    private int totalPage;
    private float price;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private Collection<OrderDetail> orderDetails = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private Collection<Review> reviews = new ArrayList<>();

    private float rating = 0f;

}
