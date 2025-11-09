package br.com.easyaccess.easyaccess.repository;

import br.com.easyaccess.easyaccess.entity.Condominio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {

    @Modifying
    @Transactional
    @Query(value = "CALL SP_INS_CONDOMINIO(:id_condominio, :nome, :endereco, :numero)", nativeQuery = true)
    void inserirCondominio( @Param("id_condominio") Integer id_condominio,
                            @Param("nome") String nome,
                            @Param("endereco") String email,
                            @Param("numero") String perfil);

    @Modifying
    @Transactional
    @Query(value = "CALL SP_UPD_CONDOMINIO(:id_condominio, :nome, :endereco, :numero)", nativeQuery = true)
    void updateCondominio(  @Param("id_condominio") Integer id_condominio,
                            @Param("nome") String nome,
                            @Param("endereco") String endereco,
                            @Param("numero") String numero);

    @Modifying
    @Transactional
    @Query(value = "CALL SP_DEL_CONDOMINIO(:id_condominio)", nativeQuery = true)
    void deletarCondominio(@Param("id_condominio") Integer id_condominio);
}

