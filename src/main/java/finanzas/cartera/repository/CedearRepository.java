package finanzas.cartera.repository;

import finanzas.cartera.model.Cedear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CedearRepository extends JpaRepository<Cedear,Long> {

}
