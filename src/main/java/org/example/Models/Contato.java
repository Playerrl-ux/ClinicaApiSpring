package org.example.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String numero;
    private String numeroEmergencia;

    public Contato(String email, String numeroEmergencia, String numero) {
        this.email = email;
        this.numeroEmergencia = numeroEmergencia;
        this.numero = numero;
    }
}
