package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.controller.dto.CondominioRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.CondominioResponseDTO;
import br.com.easyaccess.easyaccess.entity.Condominio;
import br.com.easyaccess.easyaccess.repository.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CondominioService {

    @Autowired
    private CondominioRepository condominioRepository;

    public CondominioResponseDTO salvarCondominio(CondominioRequestDTO requestDTO){
        Condominio cond = toEntity(requestDTO);
        Condominio condominioSalvo = condominioRepository.save(cond);
        return toRespDTO(condominioSalvo);
    }

    public List<CondominioResponseDTO> buscarTodos(){
        return condominioRepository.findAll()
                .stream()
                .map(this::toRespDTO)
                .collect(Collectors.toList());
    }

    public Optional<CondominioResponseDTO> buscarPorId(Long id){
        return condominioRepository.findById(id).map(this::toRespDTO);
    }

    public CondominioResponseDTO atualizar(Long id, CondominioRequestDTO requestDTO){
        return condominioRepository.findById(id)
                .map(condominio -> {
                    condominio.setNome(requestDTO.getNome());
                    condominio.setEndereco(requestDTO.getEndereco());
                    condominio.setNumero(requestDTO.getNumero());

                    Condominio condominioSalvo = condominioRepository.save(condominio);
                    return toRespDTO(condominioSalvo);
                })
                .orElseThrow(() -> new RuntimeException("Condomínio não encontrado!"));
    }

    public void deletar(Long id){
        condominioRepository.deleteById(id);
    }

    private CondominioResponseDTO toRespDTO(Condominio condominio){
        return new CondominioResponseDTO(
                condominio.getId(),
                condominio.getNome(),
                condominio.getEndereco(),
                condominio.getNumero()
        );
    }

    private Condominio toEntity(CondominioRequestDTO request){
        Condominio cond = new Condominio();
        cond.setNome(request.getNome());
        cond.setEndereco(request.getEndereco());
        cond.setNumero(request.getNumero());
        return cond;
    }

}
