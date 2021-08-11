package finanzas.cartera.service.Interface;

import finanzas.cartera.dto.response.CedearResponseDto;
import finanzas.cartera.dto.resquest.CedearResquestDto;
import finanzas.cartera.model.Cedear;

import java.util.List;

public interface ICedear {


    CedearResponseDto createCedear(CedearResquestDto CedearDto);

    CedearResponseDto updateCedear(Long id, CedearResquestDto CedearDto);

    List<CedearResponseDto> getAllCedear();

    String deleteCedear(Long id);

    Cedear getCedearById(Long id);

}
