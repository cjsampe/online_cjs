package com.online.online.service;

import com.online.online.domain.User;
import com.online.online.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user){
        /** el método save devuelve el objeto dado de alta **/
        return userRepository.save(user);

    }


}
