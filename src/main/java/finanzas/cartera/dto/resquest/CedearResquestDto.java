package finanzas.cartera.dto.resquest;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter @Setter
public class CedearResquestDto {

    @NotBlank(message = "cedear.error.blank.nombre")
    private String nombre;
    @NotBlank(message = "cedear.error.blank.simbolo")
    private String simbolo;

    private Long cantidad;

}
