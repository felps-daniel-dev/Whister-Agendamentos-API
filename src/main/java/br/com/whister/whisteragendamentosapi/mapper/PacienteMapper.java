package br.com.whister.whisteragendamentosapi.mapper;

import br.com.whister.whisteragendamentosapi.dto.PacienteRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.PacienteResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Paciente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    Paciente toEntity(PacienteRequestDTO request);

    PacienteResponseDTO toResponse(Paciente entity);
}
