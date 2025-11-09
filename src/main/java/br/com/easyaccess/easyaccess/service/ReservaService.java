package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.controller.dto.ReservaRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.ReservaResponseDTO;
import br.com.easyaccess.easyaccess.entity.AreaComum;
import br.com.easyaccess.easyaccess.entity.Morador;
import br.com.easyaccess.easyaccess.entity.Reserva;
import br.com.easyaccess.easyaccess.repository.AreaComumRepository;
import br.com.easyaccess.easyaccess.repository.MoradorRepository;
import br.com.easyaccess.easyaccess.repository.ReservaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private MoradorRepository moradorRepository;

    @Autowired
    private AreaComumRepository areaComumRepository;

    public ReservaResponseDTO salvarReserva(ReservaRequestDTO requestDTO){
        Reserva reserva = toEntity(requestDTO);
        Integer proximoId = buscarProximoId();
        reserva.setId(proximoId);
        Reserva reservaSalva = reservaRepository.save(reserva);
        return toRespDTO(reservaSalva);
    }

    public List<ReservaResponseDTO> buscarTodas(){
        return reservaRepository.findAll()
                .stream()
                .map(this::toRespDTO)
                .collect(Collectors.toList());
    }

    public Optional<ReservaResponseDTO> buscarPorId(Integer id){
        return reservaRepository.findById(Long.valueOf(id)).map(this::toRespDTO);
    }

    public ReservaResponseDTO atualizar(Integer id, ReservaRequestDTO requestDTO){
        return reservaRepository.findById(Long.valueOf(id))
                .map(reserva -> {
                    reserva.setData(requestDTO.getData());
                    reserva.setStatus(requestDTO.getStatus());
                    if (requestDTO.getMoradorId() != null){
                        Morador morador = moradorRepository.findById(Long.valueOf(requestDTO.getMoradorId()))
                                .orElseThrow(() -> new RuntimeException("Morador nao encontrado"));
                        reserva.setMorador(morador);
                    }
                    if (requestDTO.getAreaComumId() != null){
                        AreaComum areaComum = areaComumRepository.findById(Long.valueOf(requestDTO.getAreaComumId()))
                                .orElseThrow(() -> new RuntimeException("Area Comum nao encontada"));
                        reserva.setAreaComum(areaComum);
                    }
                    Reserva reservaSalva = reservaRepository.save(reserva);
                    return toRespDTO(reservaSalva);
                })
                .orElseThrow(()->new RuntimeException("Reserva não encontrada"));
    }

    public void deletar(Integer id){
        reservaRepository.deleteById(Long.valueOf(id));
    }

    private ReservaResponseDTO toRespDTO(Reserva reserva){
        return new ReservaResponseDTO(
                reserva.getId(),
                reserva.getData(),
                reserva.getStatus(),
                reserva.getMorador().getId() != null ? reserva.getMorador().getId() : null,
                reserva.getAreaComum().getId() != null ? reserva.getAreaComum().getId() : null
        );
    }

    private Reserva toEntity(ReservaRequestDTO requestDTO){
        Reserva reserva = new Reserva();
        reserva.setData(requestDTO.getData());
        reserva.setStatus(requestDTO.getStatus());
        if (requestDTO.getMoradorId() != null){
            Morador morador = moradorRepository.findById(Long.valueOf(requestDTO.getMoradorId()))
                    .orElseThrow(() -> new RuntimeException("Morador nao encontrado"));
            reserva.setMorador(morador);
        }
        if (requestDTO.getAreaComumId() != null){
            AreaComum areaComum = areaComumRepository.findById(Long.valueOf(requestDTO.getAreaComumId()))
                    .orElseThrow(() -> new RuntimeException("Area Comum nao encontada"));
            reserva.setAreaComum(areaComum);
        }
        return reserva;
    }

    @Autowired
    private EntityManager entityManager;

    private Integer buscarProximoId() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_RESERVA), 0) + 1 FROM T_EA_RESERVA");
        return ((Number) query.getSingleResult()).intValue();
    }
}
