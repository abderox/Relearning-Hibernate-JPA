package com.adria.springbootdemo.repositories;

import com.adria.springbootdemo.entities.Compte;
import com.adria.springbootdemo.entities.TypeCompte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteREpository extends JpaRepository<Compte, Long> {

    List<Compte> findAllBySoldeIsLessThanEqual(double solde);
     // ! using hql
    @Query("select c from Compte c where c.solde > :x")
    Page<Compte> chercherparsoldeinf(@Param("x") double solde, Pageable pageable);

}
