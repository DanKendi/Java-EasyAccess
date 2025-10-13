package br.com.easyaccess.easyaccess.controller;


import br.com.easyaccess.easyaccess.entity.Reserva;
import br.com.easyaccess.easyaccess.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> listarTodos(){
        return reservaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id){
        return reservaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reserva criar(@RequestBody Reserva reserva){
        return reservaService.salvar(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizar(@PathVariable Long id, @RequestBody Reserva reserva){
        try {
            return ResponseEntity.ok(reservaService.atualizar(id, reserva));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        reservaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
