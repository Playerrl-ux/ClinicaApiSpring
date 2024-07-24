package org.example.Repository;

import org.example.Models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
