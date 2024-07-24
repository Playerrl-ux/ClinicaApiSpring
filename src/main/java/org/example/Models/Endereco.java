package org.example.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bairro;
    private String rua;
    private int numeroCasa;
    private int numeroApartamento;


    public Endereco(String bairro, String rua, int numeroCasa, int numeroApartamento) {
        this.bairro = bairro;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.numeroApartamento = numeroApartamento;
    }
}
