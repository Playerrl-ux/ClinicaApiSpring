package org.example.Services;

import org.example.Exceptions.RecursoNaoExiste;
import org.example.Models.Endereco;
import org.example.Models.Medico;
import org.example.Repository.MedicoRepository;
import org.example.dto.MedicoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    EnderecoService enderecoService;

    public void criarMedico(MedicoDto medico){

        List<Endereco> enderecos = new ArrayList<>();
        Medico medicoDef = new Medico(medico.name(), medico.especialidade(), medico.telefone());
        for(Endereco endereco: medico.endereco()){
            Optional<Endereco> busca = enderecoService.procurarPorEnderecos(endereco);
            if(busca.isEmpty()){
                enderecoService.criarEndereco(endereco);
                enderecos.add(endereco);
            }else{
                enderecos.add(busca.get());
            }
        }
        medicoDef.setEnderecos(enderecos);
        medicoRepository.save(medicoDef);
    }

    public void deletarMedicoId(Long id){
        Optional<Medico> Medico = medicoRepository.findById(id);
        if(Medico.isEmpty()){
            throw new RecursoNaoExiste("O médico com id " + id + " não existe");
        }
        medicoRepository.deleteById(id);
    }

    public Optional<Medico> retornarMedico(Long id){
        return medicoRepository.findById(id);

    }

    public Medico retornarMedicoPorNome(String nome){

        Optional<Medico> buscaMedico = medicoRepository.findByName(nome);
        if(buscaMedico.isEmpty()){
            throw new RecursoNaoExiste("O médico de nome: " + nome + " não existe");
        }
        return buscaMedico.get();
    }

    public void salvarMedico(Medico medico){

        medicoRepository.save(medico);
    }


}
