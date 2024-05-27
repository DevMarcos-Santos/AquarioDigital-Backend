package com.project.peixelandia.services;

import com.project.peixelandia.domain.entities.Users;
import com.project.peixelandia.domain.repositories.UsersRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

@SpringBootTest
public class UsersService{



    private UsersService usersService;

    @MockBean
    private Users user;

    @MockBean
    private UsersRepository usersRepository;


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }



    @Test
    void create(){

        Users user = new Users();
        user.setUsername("username");
        user.setSurname("surname");
        user.setEmail("email");
        user.setPassword("password");
        user.setCreation_date(LocalDate.now());
        Mockito.when(usersRepository.save(user)).thenReturn(user);


    }
}
