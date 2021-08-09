package finanzas.cartera.dto.response;

import java.util.Date;

public interface VentaResponseDto {

    Long getId();
    Long getNroVenta();
    Double getPrecioVentaP();
    Double getPrecioVentaD();
    Long getCantidadVenta();
    Double getDifVentaCompraP();
    Double getDifVentaCompraD();
    Date getCreated();
    Date getEdited();
}
