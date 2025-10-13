package br.com.easyaccess.easyaccess.controller;

import br.com.easyaccess.easyaccess.entity.AreaComum;
import br.com.easyaccess.easyaccess.service.AreaComumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areascomuns")
public class AreaComumController {

    @Autowired
    private AreaComumService areaComumService;

    @GetMapping
    public List<AreaComum> listarTodos(){
        return areaComumService.buscarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaComum> buscarPorId(@PathVariable Long id){
        return areaComumService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AreaComum criar(@RequestBody AreaComum areaComum){
        return areaComumService.salvar(areaComum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaComum> atualizar(@PathVariable Long id, @RequestBody AreaComum areaComum){
        try {
            return ResponseEntity.ok(areaComumService.atualizar(id, areaComum));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        areaComumService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
