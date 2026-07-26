package br.com.whister.whisteragendamentosapi.service;

import br.com.whister.whisteragendamentosapi.dto.plano.PlanoRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.plano.PlanoResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Plano;
import br.com.whister.whisteragendamentosapi.exception.custom.PlanoNaoEncontrado;
import br.com.whister.whisteragendamentosapi.mapper.PlanoMapper;
import br.com.whister.whisteragendamentosapi.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoService {

    @Autowired
    PlanoMapper planoMapper;

    @Autowired
    PlanoRepository planoRepository;


    public PlanoResponseDTO novoPlano(PlanoRequestDTO request) {

        Plano plano = planoMapper.toEntity(request);

        planoRepository.save(plano);

        return planoMapper.toResponse(plano);
    }

    public PlanoResponseDTO bucarPorId(Long id) {
        Plano plano = planoRepository.findById(id)
                .orElseThrow(() -> new PlanoNaoEncontrado("Plano não encontrado!"));

        return planoMapper.toResponse(plano);
    }

    public void excluirPlano(Long id) {
        Plano plano = planoRepository.findById(id)
                        .orElseThrow(() -> new PlanoNaoEncontrado("Plano não encontrado!"));
        planoRepository.delete(plano);
    }
}
