package com.grupo7.airbnbclone.service;

import com.grupo7.airbnbclone.model.User;
import com.grupo7.airbnbclone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){return userRepository.save(user);}
    public List<User> searchAllUsers(){return userRepository.findAll();}
    public Optional<User> searchUserById(Integer id){return userRepository.findById(id);}
    public User updateUser(User user){return userRepository.save(user);}
    public void deleteUser(Integer id){userRepository.deleteById(id);}

}
