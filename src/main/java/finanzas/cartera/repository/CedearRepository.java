package finanzas.cartera.repository;

import finanzas.cartera.dto.response.CedearResponseDto;
import finanzas.cartera.model.Cedear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CedearRepository extends JpaRepository<Cedear,Long> {

    List<CedearResponseDto> findAllProjectedBy();

}
