package org.example.dto;

import org.example.Models.Endereco;

import java.util.List;

public record ClienteDto(
        String name,
        String cpf,
        int idade,
        String email,
        String numero,
        String numeroEmergencia,
        List<Endereco> endereco) {
}
