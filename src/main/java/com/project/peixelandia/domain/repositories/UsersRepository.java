package com.project.peixelandia.domain.repositories;

import com.project.peixelandia.domain.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    UserDetails findByEmail(String email);

}
