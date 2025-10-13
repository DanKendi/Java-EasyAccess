package br.com.easyaccess.easyaccess.controller;

import br.com.easyaccess.easyaccess.entity.UsuarioSistema;
import br.com.easyaccess.easyaccess.service.UsuarioSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuariossistema")
public class UsuarioSistemaController {

    @Autowired
    private UsuarioSistemaService usuarioSistemaService;

    @GetMapping
    public List<UsuarioSistema> listarTodos(){
        return usuarioSistemaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioSistema> buscarPorId(@PathVariable Long id){
        return usuarioSistemaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioSistema criar(@RequestBody UsuarioSistema areaComum){
        return usuarioSistemaService.salvar(areaComum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioSistema> atualizar(@PathVariable Long id, @RequestBody UsuarioSistema usuarioSistema){
        try {
            return ResponseEntity.ok(usuarioSistemaService.atualizar(id, usuarioSistema));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        usuarioSistemaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
