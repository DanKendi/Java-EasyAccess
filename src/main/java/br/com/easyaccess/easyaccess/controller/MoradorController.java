package br.com.easyaccess.easyaccess.controller;

import br.com.easyaccess.easyaccess.controller.dto.MoradorRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.MoradorResponseDTO;
import br.com.easyaccess.easyaccess.entity.Morador;
import br.com.easyaccess.easyaccess.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @GetMapping
    public List<MoradorResponseDTO> listarTodos(){
        return moradorService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoradorResponseDTO> buscarPorId(@PathVariable Long id){
        return moradorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MoradorResponseDTO criar(@RequestBody MoradorRequestDTO requestDTO){
        return moradorService.salvarMorador(requestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MoradorResponseDTO> atualizar(@PathVariable Long id, @RequestBody MoradorRequestDTO requestDTO){
        try {
            return ResponseEntity.ok(moradorService.atualizar(id, requestDTO));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        moradorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
