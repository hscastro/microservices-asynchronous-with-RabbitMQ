package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
