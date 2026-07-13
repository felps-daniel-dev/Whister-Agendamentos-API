package br.com.whister.whisteragendamentosapi.service;


import br.com.whister.whisteragendamentosapi.dto.PacienteRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.PacienteResponseDTO;
import br.com.whister.whisteragendamentosapi.exception.custom.PacienteNaoEncontrado;
import br.com.whister.whisteragendamentosapi.mapper.PacienteMapper;
import br.com.whister.whisteragendamentosapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;


    public PacienteResponseDTO buscaPacientePorId(Long id) {
       return pacienteMapper.toResponse(pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontrado("Paciente não encontrado!")));
    }

    public PacienteResponseDTO novoPaciente(PacienteRequestDTO request){
        return null;
    }
}
