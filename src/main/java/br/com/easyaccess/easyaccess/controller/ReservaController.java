package br.com.easyaccess.easyaccess.controller;


import br.com.easyaccess.easyaccess.controller.dto.ReservaRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.ReservaResponseDTO;
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
    public List<ReservaResponseDTO> listarTodasReservas(){
        return reservaService.buscarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> buscarReservaPorId(@PathVariable Integer id){
        return reservaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReservaResponseDTO criarReserva(@RequestBody ReservaRequestDTO requestDTO){
        return reservaService.salvarReserva(requestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> atualizarReserva(@PathVariable Integer id, @RequestBody ReservaRequestDTO requestDTO){
        try {
            return ResponseEntity.ok(reservaService.atualizar(id, requestDTO));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable Integer id){
        reservaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
