package br.com.whister.whisteragendamentosapi.service;

import br.com.whister.whisteragendamentosapi.dto.sala.SalaResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Sala;
import br.com.whister.whisteragendamentosapi.exception.custom.SalaNaoEncontrada;
import br.com.whister.whisteragendamentosapi.mapper.SalaMapper;
import br.com.whister.whisteragendamentosapi.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
     private SalaMapper salaMapper;


    public SalaResponseDTO buscarPorId(Long id){
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new SalaNaoEncontrada("Sala não Encontrada!"));

        return salaMapper.toResponse(sala);
    }
}
