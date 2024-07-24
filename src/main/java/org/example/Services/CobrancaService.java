package org.example.Services;

import org.example.Exceptions.RecursoNaoExiste;
import org.example.Models.Cobranca;
import org.example.Repository.CobrancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;



@Service
public class CobrancaService {

    @Autowired
    CobrancaRepository cobrancaRepository;

    @ResponseStatus(HttpStatus.CREATED)
    public void criarCobranca(Cobranca cobranca){
        cobrancaRepository.save(cobranca);
    }

    public ResponseEntity<String> deletarCobrancaId(@RequestBody Long id) throws Exception{
        Optional<Cobranca> cobranca = cobrancaRepository.findById(id);
        if(cobranca.isEmpty()){
            throw new RecursoNaoExiste("Cobrança com id " + id + "não existe");
        }
        cobrancaRepository.deleteById(id);
        return new ResponseEntity<>("Cobrança deletada com sucesso", HttpStatus.OK);
    }


}
