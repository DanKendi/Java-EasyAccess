package br.com.easyaccess.easyaccess.controller;

import br.com.easyaccess.easyaccess.controller.dto.CondominioRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.CondominioResponseDTO;
import br.com.easyaccess.easyaccess.entity.Condominio;
import br.com.easyaccess.easyaccess.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condominios")
public class CondominioController {

    @Autowired
    private CondominioService condominioService;

    @GetMapping
    public List<CondominioResponseDTO> listarTodosCondominios(){
        return condominioService.buscarTodosCondominios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondominioResponseDTO> buscarCondominioPorId(@PathVariable Integer id){
        return condominioService.buscarCondominioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> criarCondominio(@RequestBody CondominioRequestDTO requestDTO){
        // O service apenas executa a procedure
        condominioService.salvarCondominio(requestDTO);

        // Retorna 201 Created. Como não temos o ID gerado (a procedure não retorna),
        // não podemos retornar o objeto completo nem a URI do novo recurso.
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCondominio(@PathVariable Integer id, @RequestBody CondominioRequestDTO requestDTO){
        try {
            condominioService.atualizarCondominio(id, requestDTO);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCondominio(@PathVariable Integer id){
        condominioService.deletarCondominio(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
