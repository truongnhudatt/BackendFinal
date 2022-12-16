package com.example.demo.dto;


import com.example.demo.utils.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class UserDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

    private Role role;
    public UserDTO(String firstName, String lastName, String username, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
