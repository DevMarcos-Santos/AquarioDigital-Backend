package com.project.peixelandia.web;

import com.project.peixelandia.config.SecurityConfig;
import com.project.peixelandia.config.services.TokenService;
import com.project.peixelandia.domain.dto.LoginResponseDto;
import com.project.peixelandia.domain.dto.UserDTO;
import com.project.peixelandia.domain.entities.Peixes;
import com.project.peixelandia.domain.entities.Users;
import com.project.peixelandia.domain.services.PeixesService;
import com.project.peixelandia.domain.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;



@CrossOrigin( originPatterns = "*")
@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private AuthenticationManager authenticationManager;

    private final UsersService  usersService;

    private final PeixesService peixesService;

    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private TokenService tokenService;




    public UsersController(UsersService usersService, PeixesService peixesService) {
        this.usersService = usersService;
        this.peixesService = peixesService;
    }



    @PostMapping("/create")
    public ResponseEntity<Users> create(@RequestBody Users user){
        user.setCreation_date(LocalDate.now());
        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
        return ResponseEntity.ok(this.usersService.CreateUser(user));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Users>> findById(@PathVariable Integer id){
       Optional<Users> entity = this.usersService.FindById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody UserDTO userDTO){

        var EmailPassword = new UsernamePasswordAuthenticationToken(userDTO.email(), userDTO.password());
        var auth = this.authenticationManager.authenticate(EmailPassword);
        var token = tokenService.generateToken((Users) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(userDTO.email(), token ));
    }


    @GetMapping("/validateToken")
    public ResponseEntity validateToken(){
        return ResponseEntity.ok("Successful");
    }


}
