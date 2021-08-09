package finanzas.cartera.dto.resquest;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter @Setter
public class VentaResquestDto {

    @NotBlank
    private Double precioVentaP;

    @NotBlank
    private Double precioVentaD;

    @NotBlank
    private Long cantidadVenta;

    private Double difVentaCompraP;

    private Double difVentaCompraD;
}
