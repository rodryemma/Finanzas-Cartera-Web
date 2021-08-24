package finanzas.cartera.service.Interface;

import finanzas.cartera.dto.response.CompraResponseDto;
import finanzas.cartera.dto.resquest.CompraResquestDto;
import finanzas.cartera.model.Compra;

import java.util.List;

public interface ICompra {

    CompraResponseDto createCompra(CompraResquestDto CompraDto);

    CompraResponseDto updateCompra(Long id, CompraResquestDto CompraDto);

    List<CompraResponseDto> getAllCompra();

    String deleteCompra(Long id);

    Compra getCompraById(Long id);

    CompraResponseDto getCompraDtoById(Long id);

    Double getCompraAvgArs(Long idCedear);

    Double getCompraMontoArs(Long idCedear);

    Double getCompraAvgDol(Long idCedear);

    Double getCompraMontoDol(Long idCedear);

    Long getCompraCantidad(Long idCedear);

}
