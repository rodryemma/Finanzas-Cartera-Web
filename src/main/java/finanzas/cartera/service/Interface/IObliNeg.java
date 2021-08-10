package finanzas.cartera.service.Interface;

import finanzas.cartera.dto.response.ObligNegResponseDto;
import finanzas.cartera.dto.resquest.ObliNegResquestDto;
import finanzas.cartera.model.ObliNeg;

import java.util.List;

public interface IObliNeg {

    ObligNegResponseDto createObliNeg(ObliNegResquestDto ObliNegDto);

    ObligNegResponseDto updateObliNeg(Long id, ObliNegResquestDto ObliNegDto);

    List<ObligNegResponseDto> getAllObliNeg();

    void deleteObliNeg(Long id);

    ObliNeg getObliNegById(Long id);

}
