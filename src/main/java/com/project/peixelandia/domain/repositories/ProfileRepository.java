package com.project.peixelandia.domain.repositories;

import com.project.peixelandia.domain.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
