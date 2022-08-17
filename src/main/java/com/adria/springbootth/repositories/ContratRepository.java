package com.adria.springbootth.repositories;

import com.adria.springbootth.entities.Contrat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
 List<Contrat> findByTitle(String title);
 Page<Contrat> findByTitleContaining(String title, Pageable pageable);

}
