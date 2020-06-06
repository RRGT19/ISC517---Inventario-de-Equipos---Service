package com.example.demo.service;

import com.example.demo.exception.BadCredentialsException;
import com.example.demo.exception.ResourceExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.LoginDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.SubFamilyRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

  // Required dependencies
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  // Constructor-based dependency injection
  @Autowired
  public UserServiceImpl(
          UserRepository userRepository,
          RoleRepository roleRepository,
          BCryptPasswordEncoder bCryptPasswordEncoder
  ) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public User login(LoginDto loginRequest) {
    User currentUser = userRepository.findUserByUsername(loginRequest.username);

    if (currentUser == null)
      throw new ResourceNotFoundException();

    if (bCryptPasswordEncoder.matches(loginRequest.password, currentUser.getPassword()))
      return currentUser;
    else
      throw new BadCredentialsException();
  }

  @Override
  public User findUserByUsername(String username) {
    return userRepository.findUserByUsername(username);
  }

  @Override
  public User saveUser(User user) {
    User currentUser = userRepository.findUserByUsername(user.getUsername());

    if (currentUser != null)
      throw new ResourceExistsException();

    User newUser = new User();
    newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    newUser.setActive(Boolean.TRUE);
    newUser.setUsername(user.getUsername());
    newUser.setLastName(user.getLastName());
    newUser.setName(user.getName());
    Role userRole = roleRepository.findByRole("USER");
    newUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    return userRepository.save(newUser);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }
}
