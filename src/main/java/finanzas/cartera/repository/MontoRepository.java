package finanzas.cartera.repository;

import finanzas.cartera.dto.response.MontoResponseDto;
import finanzas.cartera.model.Monto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MontoRepository extends JpaRepository<Monto,Long> {

    List<MontoResponseDto> findAllProjectedBy();
}
