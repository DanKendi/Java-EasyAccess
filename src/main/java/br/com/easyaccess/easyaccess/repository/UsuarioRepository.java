package br.com.easyaccess.easyaccess.repository;

import br.com.easyaccess.easyaccess.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Modifying
    @Transactional
    @Query(value = "CALL SP_INS_USUARIO(:id_usuario,:nome, :email, :senha_hash, :perfil)", nativeQuery = true)
    void inserirUsuario(@Param("id_usuario") Integer id_usuario,
                        @Param("nome") String nome,
                        @Param("email") String email,
                        @Param("senha_hash") String senha_hash,
                        @Param("perfil") String perfil);

    @Modifying
    @Transactional
    @Query(value = "CALL SP_UPD_USUARIO(:id_usuario, :nome, :email, :senha_hash, :perfil)", nativeQuery = true)
    void updateUsuario( @Param("id_usuario") Integer id_usuario,
                        @Param("nome") String nome,
                        @Param("email") String email,
                        @Param("senha_hash") String senha_hash,
                        @Param("perfil") String perfil);

    @Modifying
    @Transactional
    @Query(value = "CALL SP_DEL_USUARIO(:id_usuario)", nativeQuery = true)
    void deletarUsuario(@Param("id_usuario") Integer id_usuario);
}
