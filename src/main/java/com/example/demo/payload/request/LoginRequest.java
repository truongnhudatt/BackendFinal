package com.example.demo.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
