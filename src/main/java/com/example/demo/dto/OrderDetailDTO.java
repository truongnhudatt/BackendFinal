package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailDTO {
    private long id;
    private BookDTO bookDTO;
    private float price;
    private int quantity;
    private float unitPrice;
}
