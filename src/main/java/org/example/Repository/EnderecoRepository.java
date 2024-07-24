package org.example.Repository;

import org.example.Models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Optional<Endereco> findByRuaAndBairroAndNumeroCasaAndNumeroApartamento(String rua, String bairro, int numeroCasa, int numeroApartamento);
}
