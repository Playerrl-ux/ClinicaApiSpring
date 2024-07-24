package org.example.Controllers;

import org.example.Exceptions.RecursoNaoExiste;
import org.example.Models.Cliente;
import org.example.Models.Medico;
import org.example.Services.ClienteService;
import org.example.dto.ClienteDto;
import org.example.dto.MedicoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/criar")
    public ResponseEntity<String> salvarCliente(@RequestBody ClienteDto cliente) throws Exception{

        clienteService.criarCliente(cliente);
        return new ResponseEntity<>("Cliente criado com sucesso", HttpStatus.CREATED);

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ClienteDto> buscarMedico(@PathVariable("id") Long id){
        Cliente cliente1 = clienteService.retornarCliente(id);
        ClienteDto clienteDto = new ClienteDto(cliente1.getName(), cliente1.getCpf(), cliente1.getIdade(),
                cliente1.getContato().getEmail(), cliente1.getContato().getNumero(), cliente1.getContato().getNumeroEmergencia(),
                cliente1.getEnderecos());
        return new ResponseEntity<>(clienteDto, HttpStatus.OK);
    }

}
