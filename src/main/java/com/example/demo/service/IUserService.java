package com.example.demo.service;

import com.example.demo.model.LoginDto;
import com.example.demo.model.User;

import java.util.List;

public interface IUserService {
  User findUserByUsername(String username);
  User saveUser(User user);
  User login(LoginDto loginRequest);
  List<User> findAll();
}
