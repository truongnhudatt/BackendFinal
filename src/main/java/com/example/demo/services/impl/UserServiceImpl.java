package com.example.demo.services.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.models.User;
import com.example.demo.payload.response.UserResponse;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("USER WITH USERNAME " + username + "NOT FOUND")
                );
    }

//    public UserResponse findUserByUsername(String username) throws UsernameNotFoundException{
//        Optional<User> user = userRepository.findByUsername(username);
//        if(user.isPresent()){
//            return mapper.toUserResponse(user.get());
//        }
//        return null;
//    }
//
//    public UserResponse save(UserDTO userDTO){
//        User user = mapper.toUser(userDTO);
//        return mapper.toUserResponse(userRepository.save(user));
//    }

//    public User findUserByUsername(String username){
//        return
//    }
    public User findUserByUsername(String username) throws UsernameNotFoundException{
    Optional<User> user = userRepository.findByUsername(username);
    if(user.isPresent()){
        return user.get();
    }
    return null;
}

    public User save(UserDTO userDTO){
        User user = mapper.toUser(userDTO);
        return userRepository.save(user);
    }
}
