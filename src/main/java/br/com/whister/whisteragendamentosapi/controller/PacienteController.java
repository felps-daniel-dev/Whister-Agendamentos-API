package br.com.whister.whisteragendamentosapi.controller;

import br.com.whister.whisteragendamentosapi.dto.PacienteRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.PacienteResponseDTO;
import br.com.whister.whisteragendamentosapi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(pacienteService.buscaPacientePorId(id));
    }

    @PostMapping("/novo")
    public ResponseEntity<PacienteResponseDTO> novoPaciente(@RequestBody PacienteRequestDTO request){
        return ResponseEntity.ok().body(pacienteService.novoPaciente(request));
    }
}
