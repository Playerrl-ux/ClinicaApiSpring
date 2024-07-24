package org.example.Controllers;

import org.example.Models.Consulta;
import org.example.Services.ClienteService;
import org.example.Services.ConsultaService;
import org.example.dto.ConsultaDto;
import org.example.dto.DiagnositcoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/agendar")
    public ResponseEntity<String> agendarConsulta(@RequestBody ConsultaDto consultaDto){

        consultaService.criarConsulta(consultaDto);
        return new ResponseEntity<>("Consulta agendada com sucesso", HttpStatus.CREATED);
    }

    @PutMapping("/diagnosticar/{id}")
    public ResponseEntity<String> atribuirDiagnostico(@PathVariable("id") Long id, @RequestBody DiagnositcoDto dto){

        consultaService.associarDiagnostico(dto, id);
        return new ResponseEntity<>("Diagnostico associado com sucesso", HttpStatus.OK);
    }
}
