package br.com.easyaccess.easyaccess.security;

import br.com.easyaccess.easyaccess.repository.ReservaRepository;
import br.com.easyaccess.easyaccess.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaSecurityService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean isMoradorDaReserva(Long reservaId, String email) {
        return reservaRepository.findById(reservaId)
                .map(reserva -> reserva.getMorador()
                        .getUsuario()
                        .getEmail()
                        .equals(email))
                .orElse(false);
    }

}
