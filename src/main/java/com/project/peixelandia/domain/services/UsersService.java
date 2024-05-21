package com.project.peixelandia.domain.services;

import com.project.peixelandia.domain.entities.Users;
import com.project.peixelandia.domain.repositories.UserRepository;
import com.project.peixelandia.domain.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;


@Service
@SpringBootApplication
public class UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    private Map<String, Integer> verificationCodes = new HashMap<>();
    private Map<String, Integer> recuperationCodes = new HashMap<>();



    public Users CreateUser(Users user){

        Users exists = this.userRepository.findByEmail(user.getEmail());
        if(exists == null){
            Random rand = new Random();
            int number = 1000 + rand.nextInt(9000);
            emailService.envioEmail(user.getEmail(), "Código de Verificação", "SEGUE O CÓDIGO DE VERIFICAÇÃO: " + String.valueOf(number));
            verificationCodes.put(user.getEmail(), number);

            return user;
        }else{
            throw new  RuntimeException("Email Already Exists");
        }

    }


    public Users UserConfirm(Users user, Integer digito){
        Integer code = verificationCodes.get(user.getEmail());
        if(digito.equals(code)){
            usersRepository.save(user);
            verificationCodes.remove(user.getEmail());
        }else{
            throw new  RuntimeException("Digito incorreto");
        }

        return user;
    }

    public Users passwordRecuperation(Users user){
        Random rand = new Random();
        int number = 1000 + rand.nextInt(9000);
        emailService.envioEmail(user.getEmail(), "Recuperação de senha", "SEGUE O CÓDIGO DE RECUPERAÇÃO: " + String.valueOf(number) );
        recuperationCodes.put(user.getEmail(), number);
        return user;
    }

    public Users getId(String email){
         return userRepository.findByEmail(email);
    }

    public Users passwordConfirm(Users user, Integer code){
        Integer digito = recuperationCodes.get(user.getEmail());
        if(code.equals(digito)){
            usersRepository.save(user);
            recuperationCodes.remove(user.getEmail());
        }else{
            throw new  RuntimeException("Digito incorreto");
        }
        return user;
    }





    

}
