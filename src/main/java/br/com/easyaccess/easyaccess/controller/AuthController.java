package br.com.easyaccess.easyaccess.controller;

import br.com.easyaccess.easyaccess.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(HttpServletRequest request) {
        // O FirebaseAuthFilter já validou o token e populou o SecurityContext
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        return usuarioRepository.findByEmail(email)
                .map(u -> ResponseEntity.ok(Map.of(
                        "email", u.getEmail(),
                        "nome", u.getNome(),
                        "perfil", u.getPerfil()
                )))
                .orElse(ResponseEntity.status(404).build());
    }
}
