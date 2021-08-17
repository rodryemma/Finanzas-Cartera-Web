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

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;

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
    public MontoResponseDto updateMonto(Long id, MontoResquestDto montoDto) {

        Monto monto= getMontoById(id);

     if(montoDto.getMontoIngresado() != null)
        	monto.setMontoIngresado(montoDto.getMontoIngresado());
     if(montoDto.getMontoActual() != null)
        	monto.setMontoActual(montoDto.getMontoActual());
     if(montoDto.getMontoRetirado() != null)
            monto.setMontoRetirado(montoDto.getMontoRetirado());

      return projectionFactory.createProjection(MontoResponseDto.class, montoRepository.save(monto));

    }

    @Override
    public List<MontoResponseDto> getAllMonto() {
        return montoRepository.findAllProjectedBy();
    }

    @Override
    public String deleteMonto(Long id) {

    Monto monto = getMontoById(id);
          montoRepository.delete(monto);

          return messageSource.getMessage(
                  "monto.delete.successful", null, Locale.getDefault()
            );

    }

    @Override
    public Monto getMontoById(Long id) {

        return montoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        messageSource.getMessage("monto.error.not.found", null, Locale.getDefault())
                )
        );

    }
}
