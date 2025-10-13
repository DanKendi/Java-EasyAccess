package br.com.easyaccess.easyaccess.repository;

import br.com.easyaccess.easyaccess.entity.Condominio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {

    Page<Condominio> findByEnderecoIgnoreCase(String endereco, Pageable pageable);
}

