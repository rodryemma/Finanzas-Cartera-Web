package finanzas.cartera.dto.resquest;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter @Setter
public class CedearResquestDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String simbolo;

    private Long cantidad;

}
