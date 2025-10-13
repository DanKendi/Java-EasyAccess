package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.entity.UsuarioSistema;
import br.com.easyaccess.easyaccess.repository.UsuarioSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSistemaService {

    @Autowired
    private UsuarioSistemaRepository usuarioSistemaRepository;

    public UsuarioSistema salvar(UsuarioSistema usuarioSistema){
        return usuarioSistemaRepository.save(usuarioSistema);
    }

    public List<UsuarioSistema> buscarTodos(){
        return usuarioSistemaRepository.findAll();
    }

    public Optional<UsuarioSistema> buscarPorId(Long id){
        return usuarioSistemaRepository.findById(id);
    }

    public UsuarioSistema atualizar(Long id, UsuarioSistema updateUsuarioSistema){
        return usuarioSistemaRepository.findById(id)
                .map(usuarioSistema -> {
                    usuarioSistema.setNome(updateUsuarioSistema.getNome());
                    usuarioSistema.setEmail(updateUsuarioSistema.getEmail());
                    usuarioSistema.setPerfil(updateUsuarioSistema.getPerfil());
                    usuarioSistema.setSenha(updateUsuarioSistema.getSenha());
                    return usuarioSistemaRepository.save(usuarioSistema);
                })
                .orElseThrow(()-> new RuntimeException("Usuário não encotrado!"));
    }

    public void deletar(Long id){ usuarioSistemaRepository.deleteById(id);}
}
