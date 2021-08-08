package finanzas.cartera.repository;

import finanzas.cartera.model.ObliNeg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObliNegRepository extends JpaRepository<ObliNeg,Long> {

}
