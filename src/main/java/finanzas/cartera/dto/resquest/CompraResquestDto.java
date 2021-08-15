package finanzas.cartera.dto.resquest;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class CompraResquestDto {

    private Long nroCompra;

    @NotNull(message = "{compra.error.null.preciocomprap}")
    private Double precioCompraP;

    @NotNull(message = "{compra.error.null.preciocomprad}")
    private Double precioCompraD;

    @NotNull(message = "{compra.error.null.cantidadcompra}")
    private Long cantidadCompra;
}
