package com.algaworks.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.festa.model.Cliente;

public interface ClientesRep extends JpaRepository<Cliente, Long> {

}
