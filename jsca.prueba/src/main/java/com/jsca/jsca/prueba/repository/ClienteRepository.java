package com.jsca.jsca.prueba.repository;

import com.jsca.jsca.prueba.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
    Cliente findByName(String name);

    Cliente findByNameAndGrupo(String name, String grupo);
}
