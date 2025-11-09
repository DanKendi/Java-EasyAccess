package br.com.easyaccess.easyaccess.controller;

import br.com.easyaccess.easyaccess.controller.dto.UsuarioRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.UsuarioResponseDTO;
import br.com.easyaccess.easyaccess.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDTO> listarTodosUsuarios(){
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorId(@PathVariable Integer id){
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> criarUsuario(@RequestBody UsuarioRequestDTO requestDTO){
        usuarioService.salvarUsuario(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioRequestDTO requestDTO){
        try {
            usuarioService.atualizar(id, requestDTO);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id){
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
