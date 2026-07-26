package br.com.whister.whisteragendamentosapi.controller;


import br.com.whister.whisteragendamentosapi.dto.plano.PlanoRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.plano.PlanoResponseDTO;
import br.com.whister.whisteragendamentosapi.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plano")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping
    public ResponseEntity<PlanoResponseDTO> novoPlano(@RequestBody PlanoRequestDTO request) {
        return ResponseEntity.ok().body(planoService.novoPlano(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPlano(@PathVariable Long id) {
        planoService.excluirPlano(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlanoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(planoService.bucarPorId(id));
    }
}
