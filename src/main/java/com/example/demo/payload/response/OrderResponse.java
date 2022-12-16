package com.example.demo.payload.response;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponse {
    private long id;
    private String username;
    private Collection<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
    private float total;
    private Date created;
}
