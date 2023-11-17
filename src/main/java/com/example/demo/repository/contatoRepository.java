package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.contato;

@Repository
public interface contatoRepository extends JpaRepository<contato, Long>{

}
