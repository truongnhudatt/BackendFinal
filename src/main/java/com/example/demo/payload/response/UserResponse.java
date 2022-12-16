package com.example.demo.payload.response;


import com.example.demo.utils.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private Role role;
}
