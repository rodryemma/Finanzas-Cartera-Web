package finanzas.cartera.repository;

import finanzas.cartera.dto.response.CompraResponseDto;
import finanzas.cartera.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {

    List<CompraResponseDto> findAllProjectedBy();
}
