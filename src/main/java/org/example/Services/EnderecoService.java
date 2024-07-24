package org.example.Services;

import org.example.Exceptions.RecursoNaoExiste;
import org.example.Models.Endereco;
import org.example.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public void criarEndereco(@RequestBody Endereco Endereco){
        enderecoRepository.save(Endereco);
    }

    public ResponseEntity<String> deletarEnderecoId(Long id){
        Optional<Endereco> Endereco = enderecoRepository.findById(id);
        if(Endereco.isEmpty()){
            throw new RecursoNaoExiste("O endereco com id " + id + " não existe");
        }
        enderecoRepository.deleteById(id);
        return new ResponseEntity<>("Endereco deletado com sucesso", HttpStatus.OK);
    }

    public Optional<Endereco> procurarPorEnderecos(Endereco endereco){
        return enderecoRepository.findByRuaAndBairroAndNumeroCasaAndNumeroApartamento(endereco.getRua(), endereco.getBairro(), endereco.getNumeroCasa(), endereco.getNumeroApartamento());
    }
}
