package com.example.demo.dto;


import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    private long id;
    private UserDTO userDTO;
    private List<OrderDetailDTO> detailDTOList;
    private Date created;
    private float total;
}
