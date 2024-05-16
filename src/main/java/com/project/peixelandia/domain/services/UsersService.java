package com.project.peixelandia.domain.services;

import com.project.peixelandia.domain.entities.Users;
import com.project.peixelandia.domain.repositories.UserRepository;
import com.project.peixelandia.domain.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Service
@SpringBootApplication
public class UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserRepository userRepository;




    public Users CreateUser(Users user){

        Users exists = this.userRepository.findByEmail(user.getEmail());
        if(exists == null){
            usersRepository.save(user);
            return user;
        }else{
            throw new  RuntimeException("Email Already Exists");
        }




    }



    public Optional<Users> FindById(@PathVariable Integer id) {
        return usersRepository.findById(id);
    }

    

}
