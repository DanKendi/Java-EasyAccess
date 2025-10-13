package br.com.easyaccess.easyaccess.controller;

import br.com.easyaccess.easyaccess.entity.VagaVisitante;
import br.com.easyaccess.easyaccess.service.VagaVisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagasvisitante")
public class VagaVisitanteController {

    @Autowired
    private VagaVisitanteService vagaVisitanteService;

    @GetMapping
    public List<VagaVisitante> listarTodos(){
        return vagaVisitanteService.buscarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaVisitante> buscarPorId(@PathVariable Long id){
        return vagaVisitanteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public VagaVisitante criar(@RequestBody VagaVisitante vagaVisitante){
        return vagaVisitanteService.salvar(vagaVisitante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VagaVisitante> atualizar(@PathVariable Long id, @RequestBody VagaVisitante vagaVisitante){
        try {
            return ResponseEntity.ok(vagaVisitanteService.atualizar(id, vagaVisitante));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        vagaVisitanteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
