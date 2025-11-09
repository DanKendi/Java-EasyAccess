package br.com.easyaccess.easyaccess.repository;

import br.com.easyaccess.easyaccess.entity.AreaComum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaComumRepository extends JpaRepository<AreaComum, Long> {

//    Page<AreaComum> findByNomeAreaIgnoreCase(String nomeArea,Pageable pageable);

}
