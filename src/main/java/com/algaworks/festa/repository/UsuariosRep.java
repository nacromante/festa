package com.algaworks.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.festa.model.Cliente;
import com.algaworks.festa.model.Usuario;

public interface UsuariosRep extends JpaRepository<Usuario, Long> {
	
	Usuario findByLogin(String login);

}
