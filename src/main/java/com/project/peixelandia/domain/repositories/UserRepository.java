package com.project.peixelandia.domain.repositories;

import com.project.peixelandia.domain.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
}
