package br.com.easyaccess.easyaccess.security;

import br.com.easyaccess.easyaccess.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoradorSecurityService {

    @Autowired
    private MoradorRepository moradorRepository;

    public boolean isMoradorDono(Integer moradorId, String email) {
        return moradorRepository.findById(Long.valueOf(moradorId))
                .map(morador -> morador.getUsuario().getEmail().equals(email))
                .orElse(false);
    }
}
