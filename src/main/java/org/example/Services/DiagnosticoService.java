package org.example.Services;

import org.example.Exceptions.RecursoNaoExiste;
import org.example.Models.Diagnostico;
import org.example.Repository.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
public class DiagnosticoService {

    @Autowired
    DiagnosticoRepository diagnosticoRepository;

    public void criarDiagnostico(Diagnostico diagnostico){
        diagnosticoRepository.save(diagnostico);

    }

    public void deletarDiagnosticoId(Long id){
        Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(id);
        if(diagnostico.isEmpty()){
            throw new RecursoNaoExiste("O diagnóstico com id " + id + " não existe");
        }
        diagnosticoRepository.deleteById(id);
    }


}
