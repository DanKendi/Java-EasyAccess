package br.com.easyaccess.easyaccess.repository;

import br.com.easyaccess.easyaccess.entity.VagaVisitante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaVisitanteRepository extends JpaRepository<VagaVisitante, Long> {

    Page<VagaVisitante> findByIdentificacaoInternaIgnoreCase(String identificacaoInterna, Pageable pageable);
}
