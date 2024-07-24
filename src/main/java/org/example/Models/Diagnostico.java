package org.example.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String motivacao;
    private String diagnostico;

    public Diagnostico(String motivacao, String diagnostico) {
        this.motivacao = motivacao;
        this.diagnostico = diagnostico;
    }
}
