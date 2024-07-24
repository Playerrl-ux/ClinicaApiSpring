package org.example.Services;

import org.example.Exceptions.RecursoNaoExiste;
import org.example.Models.Contato;
import org.example.Repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;


    public void criarContato(@RequestBody Contato Contato){
        contatoRepository.save(Contato);

    }

    public void deletarContatoId(Long id){
        Optional<Contato> Contato = contatoRepository.findById(id);
        if(Contato.isEmpty()){
            throw new RecursoNaoExiste("O contato com id " + id + " não existe");
        }
        contatoRepository.deleteById(id);
    }
}
