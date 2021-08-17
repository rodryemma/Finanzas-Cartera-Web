package finanzas.cartera.service.impl;

import finanzas.cartera.dto.response.MontoResponseDto;
import finanzas.cartera.dto.resquest.MontoResquestDto;
import finanzas.cartera.model.Monto;
import finanzas.cartera.repository.MontoRepository;
import finanzas.cartera.service.Interface.IMonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MontoServiceImpl implements IMonto {


    private final ProjectionFactory projectionFactory;
    private final MontoRepository montoRepository;
    private final MessageSource messageSource;

    @Autowired
    public MontoServiceImpl (ProjectionFactory projectionFactory,MontoRepository montoRepository,MessageSource messageSource){
    this.projectionFactory = projectionFactory;
    this.montoRepository = montoRepository;
    this.messageSource = messageSource;
    }




    @Override
    public MontoResponseDto createMonto(MontoResquestDto montoDto) {
        Monto monto = Monto.builder()
                .montoActual(montoDto.getMontoActual())
                .montoIngresado(montoDto.getMontoIngresado())
                .montoRetirado(montoDto.getMontoRetirado())
                .build();
        Monto montoCreated = montoRepository.save(monto);
        return projectionFactory.createProjection(MontoResponseDto.class, montoRepository.save(montoCreated));

    }

    @Override
    public MontoResponseDto updateMonto(Long id, MontoResquestDto MontoDto) {
        return null;
    }

    @Override
    public List<MontoResponseDto> getAllMonto() {
        return null;
    }

    @Override
    public void deleteMonto(Long id) {

    }

    @Override
    public Monto getMontoById(Long id) {
        return null;
    }
}
