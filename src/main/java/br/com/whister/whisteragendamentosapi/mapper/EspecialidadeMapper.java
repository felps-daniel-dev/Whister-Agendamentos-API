package br.com.whister.whisteragendamentosapi.mapper;

import br.com.whister.whisteragendamentosapi.dto.especialidade.EspecialidadeResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Especialidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EspecialidadeMapper {

    //Especialidade toEntity(EspecialidadeRequest request);


    EspecialidadeResponseDTO toResponse(Especialidade entity);
}
