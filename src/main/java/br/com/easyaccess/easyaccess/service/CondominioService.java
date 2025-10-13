package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.entity.Condominio;
import br.com.easyaccess.easyaccess.repository.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondominioService {

    @Autowired
    private CondominioRepository condominioRepository;

    public Condominio salvar(Condominio condominio){
        return condominioRepository.save(condominio);
    }

    public List<Condominio> buscarTodos(){
        return condominioRepository.findAll();
    }

    public Optional<Condominio> buscarPorId(Long id){
        return condominioRepository.findById(id);
    }

    public Condominio atualizar(Long id, Condominio updateCondominio){
        return condominioRepository.findById(id)
                .map(condominio -> {
                    condominio.setNome(updateCondominio.getNome());
                    condominio.setCnpj(updateCondominio.getCnpj());
                    condominio.setEndereco(updateCondominio.getEndereco());
                    condominio.setNumero(updateCondominio.getNumero());
                    return condominioRepository.save(condominio);
                })
                .orElseThrow(() -> new RuntimeException("Condomínio não encontrado!"));
    }

    public void deletar(Long id){
        condominioRepository.deleteById(id);
    }


}
