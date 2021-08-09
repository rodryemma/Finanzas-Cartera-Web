package finanzas.cartera.dto.response;

import java.util.Date;

public interface CompraResponseDto {

    Long getId();
    Long getNroCompra();
    Double getPrecioCompraP();
    Double getPrecioCompraD();
    Long getCantidadCompra();
    Date getCreated();
    Date getEdited();

}
