package br.com.whister.whisteragendamentosapi.service;

import br.com.whister.whisteragendamentosapi.entity.Consulta;
import br.com.whister.whisteragendamentosapi.entity.LogConsulta;
import br.com.whister.whisteragendamentosapi.repository.LogConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogConsultaService {

    @Autowired
    LogConsultaRepository logRepository;

    public void novoLog(Consulta consulta){
        LogConsulta log = LogConsulta.builder()
                .consulta(consulta)
                .alteradoPor("DESCONHECIDO")
                .statusNovo(consulta.getStatus())
                .dataHoraAlteracao(LocalDateTime.now())
                .build();
        logRepository.save(log);
    }

    public void atualizaLog(){

    }
}
