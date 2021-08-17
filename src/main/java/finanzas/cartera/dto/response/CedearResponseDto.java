package finanzas.cartera.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public interface CedearResponseDto {

    Long getId();
    String getNombre();
    String getSimbolo();
    Long getCantidad();

}
