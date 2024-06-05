package com.UserMicroservice.UserMicroservice.Service;

import com.UserMicroservice.UserMicroservice.Entitys.User;
import com.UserMicroservice.UserMicroservice.Exception.ResourceNotFoundException;

import java.util.List;

public interface UserService{

    User saveUser(User user);
    List<User> getAllUser();
    User findUserById(int userId) throws ResourceNotFoundException;

}
