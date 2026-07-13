package br.com.whister.whisteragendamentosapi.service;


import br.com.whister.whisteragendamentosapi.dto.PacienteRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.PacienteResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Paciente;
import br.com.whister.whisteragendamentosapi.exception.custom.PacienteNaoEncontrado;
import br.com.whister.whisteragendamentosapi.mapper.PacienteMapper;
import br.com.whister.whisteragendamentosapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;
    //@SQLRestriction("ativo = true")

    public PacienteResponseDTO buscaPacientePorId(Long id) {
       return pacienteMapper.toResponse(pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontrado("Paciente não encontrado!")));
    }

    public PacienteResponseDTO novoPaciente(PacienteRequestDTO request){

        Paciente paciente = pacienteMapper.toEntity(request);
        paciente.getPessoa().setDataCadastro(LocalDate.now());
        paciente.setAtivo(true);

        return pacienteMapper.toResponse(pacienteRepository.save(paciente));
    }

    public void excluirPaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontrado("Paciente não encontrado!"));
        paciente.setAtivo(false);
    }
}
