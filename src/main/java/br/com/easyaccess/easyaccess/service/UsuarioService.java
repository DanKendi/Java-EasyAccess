package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.controller.dto.UsuarioRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.UsuarioResponseDTO;
import br.com.easyaccess.easyaccess.entity.Usuario;
import br.com.easyaccess.easyaccess.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO requestDTO){
        Usuario usuario = toEntity(requestDTO);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return toRespDTO(usuarioSalvo);
    }

    public List<UsuarioResponseDTO> buscarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toRespDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioResponseDTO> buscarPorId(Long id){
        return usuarioRepository.findById(id).map(this::toRespDTO);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO requestDTO){
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(requestDTO.getNome());
                    usuario.setEmail(requestDTO.getEmail());
                    usuario.setPerfil(requestDTO.getPerfil());
                    usuario.setSenhaHash(requestDTO.getSenhaHash());

                    Usuario usuarioSalvo = usuarioRepository.save(usuario);
                    return toRespDTO(usuario);
                })
                .orElseThrow(()-> new RuntimeException("Usuário não encotrado!"));
    }

    public void deletar(Long id){ usuarioRepository.deleteById(id);}

    private UsuarioResponseDTO toRespDTO(Usuario usuario){
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getSenhaHash(),
            usuario.getPerfil(),
            usuario.getCpf()
        );
    }

    private Usuario toEntity(UsuarioRequestDTO requestDTO){
        Usuario usuario = new Usuario();
        requestDTO.setNome(requestDTO.getNome());
        requestDTO.setEmail(requestDTO.getEmail());
        requestDTO.setSenhaHash(requestDTO.getSenhaHash());
        requestDTO.setPerfil(requestDTO.getPerfil());
        requestDTO.setCpf(requestDTO.getCpf());
        return usuario;
    }
}
