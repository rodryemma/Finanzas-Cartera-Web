package finanzas.cartera.service.impl;

import finanzas.cartera.dto.response.CedearResponseDto;
import finanzas.cartera.dto.resquest.CedearResquestDto;
import finanzas.cartera.model.Cedear;
import finanzas.cartera.repository.CedearRepository;
import finanzas.cartera.service.Interface.ICedear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;

@Service
public class CedearServiceImp implements ICedear {

    private final ProjectionFactory projectionFactory;
    private final CedearRepository cedearRepository;
    private final MessageSource messageSource;

    @Autowired
    public CedearServiceImp(ProjectionFactory projectionFactory,CedearRepository cedearRepository,MessageSource messageSource){
    this.projectionFactory = projectionFactory;
    this.cedearRepository = cedearRepository;
    this.messageSource = messageSource;
    }


    @Override
    public CedearResponseDto createCedear(CedearResquestDto cedearResquestDto) {
        Cedear cedear= Cedear.builder()
                .nombre(cedearResquestDto.getNombre())
                .simbolo(cedearResquestDto.getSimbolo())
                .cantidad(cedearResquestDto.getCantidad())
                .build();
        Cedear cedearCreated = cedearRepository.save(cedear);

        return projectionFactory.createProjection(CedearResponseDto.class, cedearRepository.save(cedearCreated));
    }

    @Override
    public CedearResponseDto updateCedear(Long id, CedearResquestDto cedearDto) {

     Cedear cedear = getCedearById(id);

     if(!cedearDto.getNombre().isBlank())
        	cedear.setNombre(cedearDto.getNombre());
     if(!cedearDto.getSimbolo().isBlank())
        	cedear.setSimbolo(cedearDto.getSimbolo());
     if(cedearDto.getCantidad() != null)
        	cedear.setCantidad(cedearDto.getCantidad());

      return projectionFactory.createProjection(CedearResponseDto.class, cedearRepository.save(cedear));

    }

    @Override
    public List<CedearResponseDto> getAllCedear() {
        return cedearRepository.findAllProjectedBy();
    }

    @Override
    public String deleteCedear(Long id) {

          Cedear cedear = getCedearById(id);
          cedearRepository.delete(cedear);

          return messageSource.getMessage(
                  "cedear.delete.successful", null, Locale.getDefault()
            );

    }

    @Override
    public Cedear getCedearById(Long id) {

       return cedearRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        messageSource.getMessage("cedear.error.not.found", null, Locale.getDefault())
                )
        );

    }
}
