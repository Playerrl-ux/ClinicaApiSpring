package org.example.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataVencimento;
    private double valor;
    private boolean isPago;

    public Cobranca(Date dataVencimento, double valor, boolean isPago) {
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.isPago = isPago;
    }
}
