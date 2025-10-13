package br.com.easyaccess.easyaccess.repository;

import br.com.easyaccess.easyaccess.entity.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    interface ReservaPorMorador{
        Long getId();
        String getNome();
        Long getTotalReservas();
    }

    @Query(value = """
            SELECT m.id as ID, m.nome as nome, COUNT(r.id) as total_reservas
            FROM MORADOR m
            JOIN RESERVA r ON r.morador_id = m.id
            GROUP BY m.nome
            ORDER BY total_reservas DESC
            """,
    countQuery = "SELECT COUNT(*) from MORADOR",
    nativeQuery = true)
    Page<ReservaPorMorador> reservaMorador(Pageable pageable);
}
