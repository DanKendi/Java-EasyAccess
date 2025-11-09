package br.com.easyaccess.easyaccess.repository;

import br.com.easyaccess.easyaccess.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    Page<Usuario> findByNomeIgnoreCase(String nome, Pageable pageable);
//
//    Page<Usuario> findByEmailIgnoreCase(String email, Pageable pageable);
}
