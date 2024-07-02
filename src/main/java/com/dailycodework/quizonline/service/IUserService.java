package com.dailycodework.quizonline.service;

import com.dailycodework.quizonline.model.User;
import org.springframework.stereotype.Service;


public interface IUserService {
    User findByEmail(String email);
    User saveUser(User user);
}
