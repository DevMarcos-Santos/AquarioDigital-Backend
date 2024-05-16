package com.project.peixelandia.domain.repositories;

import com.project.peixelandia.domain.entities.Peixes;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeixesRepository extends JpaRepository<Peixes, Integer> {

    List<Peixes> findAll(Specification<Peixes> specification);
}
