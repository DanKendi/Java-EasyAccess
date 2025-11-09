package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.controller.dto.UsuarioRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.UsuarioResponseDTO;
import br.com.easyaccess.easyaccess.entity.Usuario;
import br.com.easyaccess.easyaccess.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void salvarUsuario(UsuarioRequestDTO requestDTO){
        Integer proximoId = buscarProximoId();
        Query query = entityManager.createNativeQuery(
                "CALL SP_INS_USUARIO(:id_usuario, :nome, :email, :senha_hash, :perfil)"
        );
        query.setParameter("id_usuario", proximoId);
        query.setParameter("nome", requestDTO.getNome());
        query.setParameter("email", requestDTO.getEmail());
        query.setParameter("senha_hash", requestDTO.getSenhaHash());
        query.setParameter("perfil", requestDTO.getPerfil());
        query.executeUpdate();
    }

    public List<UsuarioResponseDTO> buscarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toRespDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioResponseDTO> buscarPorId(Integer id){
        return usuarioRepository.findById(Long.valueOf(id)).map(this::toRespDTO);
    }

    @Transactional
    public void atualizar(Integer id, UsuarioRequestDTO requestDTO){
        Query query = entityManager.createNativeQuery(
                "CALL SP_INS_USUARIO(:id_usuario, :nome, :email, :senha_hash, :perfil)"
        );
        query.setParameter("id_usuario", id);
        query.setParameter("nome", requestDTO.getNome());
        query.setParameter("email", requestDTO.getEmail());
        query.setParameter("senha_hash", requestDTO.getSenhaHash());
        query.setParameter("perfil", requestDTO.getPerfil());
        query.executeUpdate();
    }

    @Transactional
    public void deletar(Integer id){
        Query query = entityManager.createNativeQuery(
                "CALL SP_DEL_USUARIO(:id_usuario)"
        );
        query.setParameter("id_usuario", id);
        query.executeUpdate();
    }

    private UsuarioResponseDTO toRespDTO(Usuario usuario){
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getSenhaHash(),
            usuario.getPerfil()
        );
    }

    private Usuario toEntity(UsuarioRequestDTO requestDTO){
        Usuario usuario = new Usuario();
        usuario.setNome(requestDTO.getNome());
        usuario.setEmail(requestDTO.getEmail());
        usuario.setSenhaHash(requestDTO.getSenhaHash());
        usuario.setPerfil(requestDTO.getPerfil());
        return usuario;
    }

    @Autowired
    private EntityManager entityManager;

    private Integer buscarProximoId() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_USUARIO), 0) + 1 FROM T_EA_USUARIO");
        return ((Number) query.getSingleResult()).intValue();
    }
}
