package finanzas.cartera.dto.resquest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PPCCedearRequestDto {
    Long idCedear;
    Double PPC;

    public PPCCedearRequestDto(Long idCedear, Double PPC) {
        this.idCedear = idCedear;
        this.PPC = PPC;
    }
}
