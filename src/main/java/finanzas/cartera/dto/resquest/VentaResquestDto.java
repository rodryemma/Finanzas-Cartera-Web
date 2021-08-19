package finanzas.cartera.dto.resquest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class VentaResquestDto {

    private Long nroVenta;

    @NotNull(message = "{venta.error.null.precioVentaP}")
    private Double precioVentaP;

    @NotNull(message = "{venta.error.null.precioVentaD}")
    private Double precioVentaD;

    @NotNull(message = "{venta.error.null.cantidadVenta}")
    private Long cantidadVenta;

    private Double difVentaCompraP;

    private Double difVentaCompraD;

    private boolean deleted = Boolean.FALSE;
}
