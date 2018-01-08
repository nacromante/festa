package com.algaworks.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.festa.model.Convidado;

public interface ConvidadosRep extends JpaRepository<Convidado, Long> {

}
