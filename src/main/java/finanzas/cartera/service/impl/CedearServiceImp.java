package finanzas.cartera.service.impl;

import finanzas.cartera.dto.response.CedearResponseDto;
import finanzas.cartera.dto.resquest.CedearResquestDto;
import finanzas.cartera.model.Cedear;
import finanzas.cartera.repository.CedearRepository;
import finanzas.cartera.service.Interface.ICedear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CedearServiceImp implements ICedear {

    private final ProjectionFactory projectionFactory;
    private final CedearRepository cedearRepository;

    @Autowired
    public CedearServiceImp(ProjectionFactory projectionFactory,CedearRepository cedearRepository){
    this.projectionFactory = projectionFactory;
    this.cedearRepository = cedearRepository;
    }


    @Override
    public CedearResponseDto createCedear(CedearResquestDto CedearResquestDto) {
        Cedear cedear= Cedear.builder()
                .nombre(CedearResquestDto.getNombre())
                .simbolo(CedearResquestDto.getSimbolo())
                .cantidad(CedearResquestDto.getCantidad())
                .build();
        Cedear cedearCreated = cedearRepository.save(cedear);

        return projectionFactory.createProjection(CedearResponseDto.class, cedearRepository.save(cedearCreated));
    }

    @Override
    public CedearResponseDto updateCedear(Long id, CedearResquestDto CedearDto) {
        return null;
    }

    @Override
    public List<CedearResponseDto> getAllCedear() {
        return null;
    }

    @Override
    public void deleteCedear(Long id) {

    }

    @Override
    public Cedear getCedearById(Long id) {
        return null;
    }
}
