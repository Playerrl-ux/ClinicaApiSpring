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
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String especialidade;
    private String telefone;

    public Medico(String name, String especialidade, String telefone) {
        this.name = name;
        this.especialidade = especialidade;
        this.telefone = telefone;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "medico_fk", referencedColumnName = "id")
    private List<Consulta> consultas;


    @ManyToMany
    @JoinTable(
            name = "medico_endereco",
            joinColumns = @JoinColumn(name = "medico_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id")
    )
    private List<Endereco> enderecos;

}
