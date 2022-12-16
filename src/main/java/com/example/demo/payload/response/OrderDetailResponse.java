package com.example.demo.payload.response;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetailResponse {
    private long id;
    private BookResponse bookResponse;
    private float price;
    private int quantity;
    private float unitPrice;
}
