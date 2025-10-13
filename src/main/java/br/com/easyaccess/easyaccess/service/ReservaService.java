package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.entity.Reserva;
import br.com.easyaccess.easyaccess.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva salvar(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    public List<Reserva> buscarTodos(){
        return reservaRepository.findAll();
    }

    public Optional<Reserva> buscarPorId(Long id){
        return reservaRepository.findById(id);
    }

    public Reserva atualizar(Long id, Reserva updateReserva){
        return reservaRepository.findById(id)
                .map(reserva -> {
                    reserva.setData(updateReserva.getData());
                    reserva.setMorador(updateReserva.getMorador());
                    reserva.setStatus(updateReserva.getStatus());
                    reserva.setValorTotal(updateReserva.getValorTotal());
                    reserva.setAreaComum(updateReserva.getAreaComum());
                    reserva.setVagaVisitante(updateReserva.getVagaVisitante());
                    return reservaRepository.save(reserva);
                })
                .orElseThrow(()->new RuntimeException("Reserva não encontrada"));
    }

    public void deletar(Long id){
        reservaRepository.deleteById(id);
    }
}
