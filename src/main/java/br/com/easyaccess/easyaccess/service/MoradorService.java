package br.com.easyaccess.easyaccess.service;


import br.com.easyaccess.easyaccess.controller.dto.MoradorRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.MoradorResponseDTO;
import br.com.easyaccess.easyaccess.entity.Condominio;
import br.com.easyaccess.easyaccess.entity.Morador;
import br.com.easyaccess.easyaccess.entity.Usuario;
import br.com.easyaccess.easyaccess.repository.CondominioRepository;
import br.com.easyaccess.easyaccess.repository.MoradorRepository;
import br.com.easyaccess.easyaccess.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CondominioRepository condominioRepository;

    public MoradorResponseDTO salvarMorador(MoradorRequestDTO request){
        Morador morador = toEntity(request);
        Integer proximoId = buscarProximoId();
        morador.setId(proximoId);
        Morador moradorSalvo = moradorRepository.save(morador);
        return toRespDTO(moradorSalvo);
    }

    public List<MoradorResponseDTO> buscarTodos(){
        return moradorRepository.findAll()
                .stream()
                .map(this::toRespDTO)
                .collect(Collectors.toList());
    }

    public Optional<MoradorResponseDTO> buscarPorId(Integer id){
        return moradorRepository.findById(Long.valueOf(id)).map(this::toRespDTO);
    }

    public MoradorResponseDTO atualizar(Integer id, MoradorRequestDTO requestDTO){
        return moradorRepository.findById(Long.valueOf(id))
                .map(morador -> {
                    if (requestDTO.getUsuarioId() != null){
                        Usuario usuario = usuarioRepository.findById(Long.valueOf(requestDTO.getUsuarioId()))
                                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
                        morador.setUsuario(usuario);
                    }
                    if (requestDTO.getCondominioId() != null){
                        Condominio condominio = condominioRepository.findById(Long.valueOf(requestDTO.getCondominioId()))
                                .orElseThrow(() -> new RuntimeException("Condominio nao encontrado"));
                        morador.setCondominio(condominio);
                    }
                    morador.setStatus(requestDTO.getStatus());
                    morador.setDataEntrada(requestDTO.getDataEntrada());

                    Morador moradorSalvo = moradorRepository.save(morador);
                    return toRespDTO(moradorSalvo);
                })
                .orElseThrow(() -> new RuntimeException("Morador não encontrado!"));
    }

    public void deletar(Integer id){
        moradorRepository.deleteById(Long.valueOf(id));
    }

    private MoradorResponseDTO toRespDTO(Morador morador){
        return new MoradorResponseDTO(
                morador.getId(),
                morador.getUsuario().getId() != null ? morador.getUsuario().getId() : null,
                morador.getCondominio().getId() != null ? morador.getUsuario().getId() : null,
                morador.getStatus(),
                morador.getDataEntrada()
        );
    }

    private Morador toEntity(MoradorRequestDTO request){
        Morador morador = new Morador();
        morador.setStatus(request.getStatus());
        morador.setDataEntrada(request.getDataEntrada());
        if (request.getUsuarioId() != null){
            Usuario usuario = usuarioRepository.findById(Long.valueOf(request.getUsuarioId()))
                    .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
            morador.setUsuario(usuario);
        }

        if (request.getCondominioId() != null){
            Condominio condominio = condominioRepository.findById(Long.valueOf(request.getCondominioId()))
                    .orElseThrow(() -> new RuntimeException("Condominio nao encontrado"));
            morador.setCondominio(condominio);
        }
        return morador;
    }

    @Autowired
    private EntityManager entityManager;

    private Integer buscarProximoId() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_MORADOR), 0) + 1 FROM T_EA_MORADOR");
        return ((Number) query.getSingleResult()).intValue();
    }
}
