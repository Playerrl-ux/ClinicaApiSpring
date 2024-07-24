package org.example.Repository;


import org.example.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);
    Optional<Cliente> findByName(String name);
}
