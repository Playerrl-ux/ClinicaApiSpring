package org.example.Services;

import org.example.Exceptions.RecursoNaoExiste;
import org.example.Models.*;
import org.example.Repository.ConsultaRepository;
import org.example.dto.ConsultaDto;
import org.example.dto.DiagnositcoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    MedicoService medicoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    CobrancaService cobrancaService;

    @Autowired
    DiagnosticoService diagnosticoService;

    public void criarConsulta(ConsultaDto consultaDto){

        Date now = new Date();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(now);
        calendario.add(Calendar.DAY_OF_MONTH, 30);
        Date dataFutura = calendario.getTime();
        Medico medico = medicoService.retornarMedicoPorNome(consultaDto.medico());
        Cliente cliente = clienteService.retornarClientePorNome(consultaDto.cliente());
        Cobranca cobranca = new Cobranca(dataFutura, consultaDto.valor(), false);
        Consulta consulta = new Consulta(consultaDto.date(), cobranca, null);
        consultaRepository.save(consulta);
        medico.getConsultas().add(consulta);
        cliente.getConsultas().add(consulta);
        clienteService.salvarCliente(cliente);
        medicoService.salvarMedico(medico);
    }

    public void deletarConsultaId(Long id){
        Optional<Consulta> Consulta = consultaRepository.findById(id);
        if(Consulta.isEmpty()){
            throw new RecursoNaoExiste("A consulta com id " + id + " não existe");
        }
        consultaRepository.deleteById(id);
    }

    public void associarDiagnostico(DiagnositcoDto dto, Long id){

        Diagnostico diagnostico = new Diagnostico(dto.causa(), dto.diagnostico());
        Optional<Consulta> buscaConsulta = consultaRepository.findById(id);
        if(buscaConsulta.isEmpty()){
            throw new RecursoNaoExiste("A consulta com id: " + " não existe");
        }
        Consulta consulta = buscaConsulta.get();
        consulta.setDiagnostico(diagnostico);
        consultaRepository.save(consulta);
    }

}
