package finanzas.cartera.repository;

import finanzas.cartera.dto.response.VentaResponseDto;
import finanzas.cartera.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long> {

    List<VentaResponseDto>findAllProjectedBy();
}
