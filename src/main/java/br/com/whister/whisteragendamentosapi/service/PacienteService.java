package br.com.whister.whisteragendamentosapi.service;


import br.com.whister.whisteragendamentosapi.dto.PacienteResponseDTO;
import br.com.whister.whisteragendamentosapi.mapper.PacienteMapper;
import br.com.whister.whisteragendamentosapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;


    public PacienteResponseDTO buscaPacientePorId(Long id) {
       return pacienteMapper.toResponse(pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado!")));
    }
}
