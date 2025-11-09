package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.controller.dto.CondominioRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.CondominioResponseDTO;
import br.com.easyaccess.easyaccess.entity.Condominio;
import br.com.easyaccess.easyaccess.repository.CondominioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CondominioService {

    @Autowired
    private CondominioRepository condominioRepository;

    @Transactional
    public void salvarCondominio(CondominioRequestDTO requestDTO){
        Integer proximoId = buscarProximoId();
        Query query = entityManager.createNativeQuery(
                "CALL SP_INS_CONDOMINIO(:id_condominio, :nome, :endereco, :numero)"
        );
        query.setParameter("id_condominio", proximoId);
        query.setParameter("nome", requestDTO.getNome());
        query.setParameter("endereco", requestDTO.getEndereco());
        query.setParameter("numero", requestDTO.getNumero());
        query.executeUpdate();
    }

    public List<CondominioResponseDTO> buscarTodosCondominios(){
        return condominioRepository.findAll()
                .stream()
                .map(this::toRespDTO)
                .collect(Collectors.toList());
    }

    public Optional<CondominioResponseDTO> buscarCondominioPorId(Integer id){
        return condominioRepository.findById(Long.valueOf(id)).map(this::toRespDTO);
    }

    @Transactional
    public void atualizarCondominio(Integer id, CondominioRequestDTO requestDTO){
        Query query = entityManager.createNativeQuery(
                "CALL SP_UPD_CONDOMINIO(:id_condominio, :nome, :endereco, :numero)"
        );
        query.setParameter("id_condominio", id);
        query.setParameter("nome", requestDTO.getNome());
        query.setParameter("endereco", requestDTO.getEndereco());
        query.setParameter("numero", requestDTO.getNumero());
        query.executeUpdate();
    }

    @Transactional
    public void deletarCondominio(Integer id){
        Query query = entityManager.createNativeQuery(
                "CALL SP_DEL_CONDOMINIO(:id_condominio)"
        );
        query.setParameter("id_condominio", id);
        query.executeUpdate();
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

    @Autowired
    private EntityManager entityManager;

    private Integer buscarProximoId() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_CONDOMINIO), 0) + 1 FROM T_EA_CONDOMINIO");
        return  ((Number) query.getSingleResult()).intValue();
    }

}
