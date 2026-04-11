package br.com.easyaccess.easyaccess.controller;

import br.com.easyaccess.easyaccess.controller.dto.AreaComumRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.AreaComumResponseDTO;
import br.com.easyaccess.easyaccess.entity.AreaComum;
import br.com.easyaccess.easyaccess.service.AreaComumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areascomuns")
public class AreaComumController {

    @Autowired
    private AreaComumService areaComumService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<AreaComumResponseDTO> listarTodasAreas(){
        return areaComumService.buscarTodasAreas();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AreaComumResponseDTO> buscarAreaPorId(@PathVariable Integer id){
        return areaComumService.buscarAreaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public AreaComumResponseDTO criarArea(@RequestBody AreaComumRequestDTO requestDTO){
        return areaComumService.salvarArea(requestDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AreaComumResponseDTO> atualizarArea(@PathVariable Integer id, @RequestBody AreaComumRequestDTO requestDTO){
        try {
            return ResponseEntity.ok(areaComumService.atualizarArea(id, requestDTO));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletarArea(@PathVariable Integer id){
        areaComumService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
