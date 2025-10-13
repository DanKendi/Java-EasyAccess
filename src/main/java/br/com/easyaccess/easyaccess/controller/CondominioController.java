package br.com.easyaccess.easyaccess.controller;

import br.com.easyaccess.easyaccess.entity.Condominio;
import br.com.easyaccess.easyaccess.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condominios")
public class CondominioController {

    @Autowired
    private CondominioService condominioService;

    @GetMapping
    public List<Condominio> listarTodos(){
        return condominioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Condominio> buscarPorId(@PathVariable Long id){
        return condominioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Condominio criar(@RequestBody Condominio condominio){
        return condominioService.salvar(condominio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Condominio> atualizar(@PathVariable Long id, @RequestBody Condominio condominio){
        try {
            return ResponseEntity.ok(condominioService.atualizar(id, condominio));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        condominioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
