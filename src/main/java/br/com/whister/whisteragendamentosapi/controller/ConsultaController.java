package br.com.whister.whisteragendamentosapi.controller;

import br.com.whister.whisteragendamentosapi.dto.consulta.ConsultaRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.consulta.ConsultaResponseDTO;
import br.com.whister.whisteragendamentosapi.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> novaConsulta(@RequestBody @Valid ConsultaRequestDTO request){
        return ResponseEntity.ok().body(consultaService.novaConsulta(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(consultaService.buscarPorId(id));
    }
}
