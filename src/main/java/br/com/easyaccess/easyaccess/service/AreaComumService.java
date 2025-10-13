package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.entity.AreaComum;
import br.com.easyaccess.easyaccess.repository.AreaComumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaComumService {

    @Autowired
    private AreaComumRepository areaComumRepository;

    public AreaComum salvar(AreaComum areaComum){
        return areaComumRepository.save(areaComum);
    }

    public List<AreaComum> buscarTodas(){
        return areaComumRepository.findAll();
    }

    public Optional<AreaComum> buscarPorId(Long id){
        return areaComumRepository.findById(id);
    }

    public AreaComum atualizar(Long id, AreaComum updateAreaComum){
        return areaComumRepository.findById(id)
                .map(areaComum -> {
                    areaComum.setNomeArea(updateAreaComum.getNomeArea());
                    areaComum.setDescricao(updateAreaComum.getDescricao());
                    areaComum.setCondominio(updateAreaComum.getCondominio());
                    areaComum.setPrecoBase(updateAreaComum.getPrecoBase());
                    return areaComumRepository.save(areaComum);
                })
                .orElseThrow(() -> new RuntimeException("Área comum não encontrada!"));
    }

    public void deletar(Long id){
        areaComumRepository.deleteById(id);
    }
}
