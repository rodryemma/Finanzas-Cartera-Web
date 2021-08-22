package finanzas.cartera.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public interface CompraResponseDto {

    Long getId();
    Long getNroCompra();
    Double getPrecioCompraP();
    Double getPrecioCompraD();
    Long getCantidadCompra();
    Date getCreated();
    Date getEdited();
    Cedear getCedear();

    interface Cedear {
        Long getId();
    }

}
