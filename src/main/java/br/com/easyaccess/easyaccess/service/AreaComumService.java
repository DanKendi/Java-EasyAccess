package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.controller.dto.AreaComumRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.AreaComumResponseDTO;
import br.com.easyaccess.easyaccess.controller.dto.CondominioResponseDTO;
import br.com.easyaccess.easyaccess.entity.AreaComum;
import br.com.easyaccess.easyaccess.entity.Condominio;
import br.com.easyaccess.easyaccess.repository.AreaComumRepository;
import br.com.easyaccess.easyaccess.repository.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AreaComumService {

    @Autowired
    private AreaComumRepository areaComumRepository;

    @Autowired
    private CondominioRepository condominioRepository;

    public AreaComumResponseDTO salvarArea(AreaComumRequestDTO request){
        AreaComum areaComum = toEntity(request);
        AreaComum areaComumSalva = areaComumRepository.save(areaComum);
        return toRespDTO(areaComumSalva);
    }

    public List<AreaComumResponseDTO> buscarTodas(){
        return areaComumRepository.findAll()
                .stream()
                .map(this::toRespDTO)
                .collect(Collectors.toList());
    }

    public Optional<AreaComumResponseDTO> buscarPorId(Long id){
        return areaComumRepository.findById(id).map(this::toRespDTO);
    }

    public AreaComumResponseDTO atualizar(Long id, AreaComumRequestDTO requestDTO){
        return areaComumRepository.findById(id)
                .map(areaComum -> {
                    areaComum.setNome(requestDTO.getNome());
                    areaComum.setDescricao(requestDTO.getDescricao());
                    areaComum.setPrecoBase(requestDTO.getPrecoBase());
                    if (requestDTO.getCondominioId() != null){
                        Condominio condominio = condominioRepository.findById(requestDTO.getCondominioId())
                                .orElseThrow(() -> new RuntimeException("Condominio nao encontrado!"));
                        areaComum.setCondominio(condominio);
                    }
                    AreaComum areaComumSalva = areaComumRepository.save(areaComum);
                    return toRespDTO(areaComumSalva);
                })
                .orElseThrow(() -> new RuntimeException("Área comum não encontrada!"));
    }

    public void deletar(Long id){
        areaComumRepository.deleteById(id);
    }

    private AreaComumResponseDTO toRespDTO(AreaComum areaComum){
        return new AreaComumResponseDTO(
                areaComum.getId(),
                areaComum.getNome(),
                areaComum.getDescricao(),
                areaComum.getPrecoBase(),
                areaComum.getCondominio().getId() != null ? areaComum.getCondominio().getId() : null
        );
    }

    private AreaComum toEntity(AreaComumRequestDTO request){
        AreaComum areaC = new AreaComum();
        areaC.setNome(request.getNome());
        areaC.setDescricao(request.getDescricao());
        areaC.setPrecoBase(request.getPrecoBase());
        if (request.getCondominioId() != null){
            Condominio condominio = condominioRepository.findById(request.getCondominioId())
                    .orElseThrow(() -> new RuntimeException("Condominio nao encontrado!"));
            areaC.setCondominio(condominio);
        }
        return areaC;
    }
}
