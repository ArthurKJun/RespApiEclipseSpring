package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.locais;

@Repository
public interface locaisRepository extends JpaRepository<locais, Long>{

}
