package org.example.Repository;

import org.example.Models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Optional<Medico> findByName(String name);
}
