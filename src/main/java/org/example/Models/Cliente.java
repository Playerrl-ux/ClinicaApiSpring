package org.example.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cpf;
    private int idade;

    public Cliente(String name, String cpf, int idade) {
        this.name = name;
        this.cpf = cpf;
        this.idade = idade;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_fk", referencedColumnName = "id")
    private List<Consulta> consultas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_fk", referencedColumnName = "id")
    private Contato contato;

    @ManyToMany
    @JoinTable(
            name = "cliente_endereco",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id")
    )
    private List<Endereco> enderecos;


}
