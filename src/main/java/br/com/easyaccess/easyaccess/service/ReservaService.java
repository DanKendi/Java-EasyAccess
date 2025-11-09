package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.controller.dto.ReservaRequestDTO;
import br.com.easyaccess.easyaccess.controller.dto.ReservaResponseDTO;
import br.com.easyaccess.easyaccess.entity.AreaComum;
import br.com.easyaccess.easyaccess.entity.Morador;
import br.com.easyaccess.easyaccess.entity.Reserva;
import br.com.easyaccess.easyaccess.repository.AreaComumRepository;
import br.com.easyaccess.easyaccess.repository.MoradorRepository;
import br.com.easyaccess.easyaccess.repository.ReservaRepository;
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
        Reserva reservaSalva = reservaRepository.save(reserva);
        return toRespDTO(reservaSalva);
    }

    public List<ReservaResponseDTO> buscarTodas(){
        return reservaRepository.findAll()
                .stream()
                .map(this::toRespDTO)
                .collect(Collectors.toList());
    }

    public Optional<ReservaResponseDTO> buscarPorId(Long id){
        return reservaRepository.findById(id).map(this::toRespDTO);
    }

    public ReservaResponseDTO atualizar(Long id, ReservaRequestDTO requestDTO){
        return reservaRepository.findById(id)
                .map(reserva -> {
                    reserva.setData(requestDTO.getData());
                    reserva.setStatus(requestDTO.getStatus());
                    if (requestDTO.getMoradorId() != null){
                        Morador morador = moradorRepository.findById(requestDTO.getMoradorId())
                                .orElseThrow(() -> new RuntimeException("Morador nao encontrado"));
                        reserva.setMorador(morador);
                    }
                    if (requestDTO.getAreaComumId() != null){
                        AreaComum areaComum = areaComumRepository.findById(requestDTO.getAreaComumId())
                                .orElseThrow(() -> new RuntimeException("Area Comum nao encontada"));
                        reserva.setAreaComum(areaComum);
                    }
                    Reserva reservaSalva = reservaRepository.save(reserva);
                    return toRespDTO(reservaSalva);
                })
                .orElseThrow(()->new RuntimeException("Reserva não encontrada"));
    }

    public void deletar(Long id){
        reservaRepository.deleteById(id);
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
            Morador morador = moradorRepository.findById(requestDTO.getMoradorId())
                    .orElseThrow(() -> new RuntimeException("Morador nao encontrado"));
            reserva.setMorador(morador);
        }
        if (requestDTO.getAreaComumId() != null){
            AreaComum areaComum = areaComumRepository.findById(requestDTO.getAreaComumId())
                    .orElseThrow(() -> new RuntimeException("Area Comum nao encontada"));
            reserva.setAreaComum(areaComum);
        }
        return reserva;
    }
}
