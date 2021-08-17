package finanzas.cartera.service.Interface;

import finanzas.cartera.dto.response.MontoResponseDto;
import finanzas.cartera.dto.resquest.MontoResquestDto;
import finanzas.cartera.model.Monto;

import java.util.List;

public interface IMonto {

    MontoResponseDto createMonto(MontoResquestDto MontoDto);

    MontoResponseDto updateMonto(Long id, MontoResquestDto MontoDto);

    List<MontoResponseDto> getAllMonto();

    String deleteMonto(Long id);

    Monto getMontoById(Long id);

}
