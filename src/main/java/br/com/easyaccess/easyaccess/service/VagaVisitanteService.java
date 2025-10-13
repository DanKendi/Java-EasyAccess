package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.entity.VagaVisitante;
import br.com.easyaccess.easyaccess.repository.VagaVisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaVisitanteService {

    @Autowired
    private VagaVisitanteRepository vagaVisitanteRepository;

    public VagaVisitante salvar(VagaVisitante vagaVisitante){
        return vagaVisitanteRepository.save(vagaVisitante);
    }

    public List<VagaVisitante> buscarTodas(){
        return vagaVisitanteRepository.findAll();
    }

    public Optional<VagaVisitante> buscarPorId(Long id){
        return vagaVisitanteRepository.findById(id);
    }

    public VagaVisitante atualizar(Long id, VagaVisitante updateVagaVisitante){
        return vagaVisitanteRepository.findById(id)
                .map(vagaVisitante -> {
                    vagaVisitante.setIdentificacaoInterna(updateVagaVisitante.getIdentificacaoInterna());
                    vagaVisitante.setCondominio(updateVagaVisitante.getCondominio());
                    return vagaVisitanteRepository.save(vagaVisitante);
                })
                .orElseThrow(() -> new RuntimeException("Vaga de Visitante não encontrada!"));
    }

    public void deletar(Long id){vagaVisitanteRepository.deleteById(id);}
}
