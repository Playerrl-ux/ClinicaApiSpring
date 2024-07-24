package org.example.dto;

import org.example.Models.Endereco;

import java.util.List;

public record MedicoDto(
        String name,
        String especialidade,
        String telefone,
        List<Endereco> endereco) {
}
