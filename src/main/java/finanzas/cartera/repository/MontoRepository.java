package finanzas.cartera.repository;

import finanzas.cartera.model.Monto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MontoRepository extends JpaRepository<Monto,Long> {

}
