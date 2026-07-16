package br.com.whister.whisteragendamentosapi.service;

import br.com.whister.whisteragendamentosapi.dto.medico.MedicoRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.medico.MedicoResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Especialidade;
import br.com.whister.whisteragendamentosapi.entity.Medico;
import br.com.whister.whisteragendamentosapi.exception.custom.EspecialidadeNaoEncontrada;
import br.com.whister.whisteragendamentosapi.exception.custom.MedicoNaoEncontrado;
import br.com.whister.whisteragendamentosapi.mapper.MedicoMapper;
import br.com.whister.whisteragendamentosapi.repository.EspecialidadeRepository;
import br.com.whister.whisteragendamentosapi.repository.MedicoRepository;
import org.hibernate.annotations.SQLDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicoService {


    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoMapper medicoMapper;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;


    public MedicoResponseDTO buscarMedicoPorId(Long id) {
        return medicoMapper.toResponse(medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNaoEncontrado("Medico não encontrado!")));
    }

    public MedicoResponseDTO novoMedico(MedicoRequestDTO request) {
        Especialidade especialidade = especialidadeRepository.findById(request.especialidadeId())
                .orElseThrow(() -> new EspecialidadeNaoEncontrada("Especialidade não existe!"));

        Medico medico = medicoMapper.toEntity(request);
        medico.setEspecialidade(especialidade);

        medicoRepository.save(medico);

        return medicoMapper.toResponse(medico);
    }

    public void excluirMedico(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNaoEncontrado("Medico não encontrado!"));
        medicoRepository.delete(medico);
    }
}
