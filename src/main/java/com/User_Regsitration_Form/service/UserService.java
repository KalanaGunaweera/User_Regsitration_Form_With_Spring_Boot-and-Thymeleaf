package com.User_Regsitration_Form.service;

import com.User_Regsitration_Form.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void saveUser(User user);
    List<User> getAllUsers();
}
