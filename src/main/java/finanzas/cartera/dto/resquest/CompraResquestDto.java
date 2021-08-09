package finanzas.cartera.dto.resquest;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter @Setter
public class CompraResquestDto {

    private Long nroCompra;

    @NotBlank
    private Double precioCompraP;

    @NotBlank
    private Double precioCompraD;

    @NotBlank
    private Long cantidadCompra;

}
