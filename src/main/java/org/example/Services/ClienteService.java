package org.example.Services;

import org.example.Exceptions.RecursoJaExiste;
import org.example.Exceptions.RecursoNaoExiste;
import org.example.Models.Cliente;
import org.example.Models.Contato;
import org.example.Models.Endereco;
import org.example.Repository.ClienteRepository;
import org.example.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoService enderecoService;

    @Autowired
    ContatoService contatoService;

    public void criarCliente(@RequestBody ClienteDto clienteDto) throws RecursoJaExiste{
        Optional<Cliente> busca = clienteRepository.findByCpf(clienteDto.cpf());
        if(busca.isPresent()){
            throw new RecursoJaExiste("Já existe um cliente com esse cpf");
        }

        Cliente cliente = new Cliente(clienteDto.name(), clienteDto.cpf(), clienteDto.idade());
        Contato contato = new Contato(clienteDto.email(), clienteDto.numero(),clienteDto.numeroEmergencia());
        List<Endereco> enderecos = new ArrayList<>();
        for(Endereco endereco: clienteDto.endereco()) {
            Optional<Endereco> procura = enderecoService.procurarPorEnderecos(endereco);
            Endereco endereco1;
            if(procura.isEmpty()) {
                enderecoService.criarEndereco(endereco);
                enderecos.add(endereco);
            }else{
                enderecos.add(procura.get());
            }
        }
        contatoService.criarContato(contato);
        cliente.setContato(contato);
        cliente.setEnderecos(enderecos);
        cliente.setConsultas(new ArrayList<>());
        clienteRepository.save(cliente);
    }

    public void deletarClienteId(Long id){
        Optional<Cliente> Cliente = clienteRepository.findById(id);
        if(Cliente.isEmpty()){
            throw new RecursoNaoExiste("O Cliente com id " + id + " não existe");
        }
        clienteRepository.deleteById(id);
    }

    public Cliente retornarCliente(Long id){
        Optional<Cliente> clienteBusca = clienteRepository.findById(id);
        if(clienteBusca.isEmpty()){
            throw new RecursoNaoExiste("O Cliente com id: " + id + " não existe");
        }
        return clienteBusca.get();
    }

    public Cliente retornarClientePorNome(String nome){

        Optional<Cliente> buscaCliente = clienteRepository.findByName(nome);
        if(buscaCliente.isEmpty()){
            throw new RecursoNaoExiste("O cliente de nome: " + nome + " não existe");
        }
        return buscaCliente.get();
    }

    public void salvarCliente(Cliente cliente){

        clienteRepository.save(cliente);
    }
}
