package br.com.easyaccess.easyaccess.service;


import br.com.easyaccess.easyaccess.entity.Morador;
import br.com.easyaccess.easyaccess.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    public Morador salvar(Morador morador){
        return moradorRepository.save(morador);
    }

    public List<Morador> buscarTodos(){
        return moradorRepository.findAll();
    }

    public Optional<Morador> buscarPorId(Long id){
        return moradorRepository.findById(id);
    }

    public Morador atualizar(Long id, Morador updateMorador){
        return moradorRepository.findById(id)
                .map(morador -> {
                    morador.setCondominio(updateMorador.getCondominio());
                    morador.setUsuarioSistema(updateMorador.getUsuarioSistema());
                    return moradorRepository.save(morador);
                })
                .orElseThrow(() -> new RuntimeException("Morador não encontrado!"));
    }

    public void deletar(Long id){
        moradorRepository.deleteById(id);
    }
}
