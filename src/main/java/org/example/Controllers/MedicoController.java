package org.example.Controllers;

import org.example.Exceptions.RecursoNaoExiste;
import org.example.Models.Medico;
import org.example.Services.MedicoService;
import org.example.dto.MedicoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarMedico(@RequestBody MedicoDto medico){
        medicoService.criarMedico(medico);
        return new ResponseEntity<>("Medico cadastrado com sucesso", HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<MedicoDto> buscarMedico(@PathVariable("id") Long id){
        Optional<Medico> medico = medicoService.retornarMedico(id);
        if(medico.isEmpty()){
            throw new RecursoNaoExiste("O médico com o id: " + id + " não existe" );
        }
        Medico medico1 = medico.get();
        MedicoDto medicoDto = new MedicoDto(medico1.getName(), medico1.getEspecialidade(), medico1.getTelefone(), medico1.getEnderecos());
        return new ResponseEntity<>(medicoDto, HttpStatus.OK);
    }
}
