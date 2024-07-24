package org.example.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataHora;

    public Consulta(Date dataHora, Cobranca cobranca, Diagnostico diagnostico) {
        this.dataHora = dataHora;
        this.cobranca = cobranca;
        this.diagnostico = diagnostico;
    }

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cobranca_fk", referencedColumnName = "id")
    private Cobranca cobranca;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnostico_fk", referencedColumnName = "id")
    private Diagnostico diagnostico;
}
