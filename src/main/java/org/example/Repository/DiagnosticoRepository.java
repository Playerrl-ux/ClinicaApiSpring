package org.example.Repository;

import org.example.Models.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {
}
