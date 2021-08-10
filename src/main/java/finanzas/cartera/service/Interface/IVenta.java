package finanzas.cartera.service.Interface;

import finanzas.cartera.dto.response.VentaResponseDto;
import finanzas.cartera.dto.resquest.VentaResquestDto;
import finanzas.cartera.model.Venta;

import java.util.List;

public interface IVenta {

    VentaResponseDto createVenta(VentaResquestDto VentaDto);

    VentaResponseDto updateVenta(Long id, VentaResquestDto VentaDto);

    List<VentaResponseDto> getAllVenta();

    void deleteVenta(Long id);

    Venta getVentaById(Long id);

}
