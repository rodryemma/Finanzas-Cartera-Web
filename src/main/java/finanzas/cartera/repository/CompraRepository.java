package finanzas.cartera.repository;

import finanzas.cartera.dto.response.CompraResponseDto;
import finanzas.cartera.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CompraRepository extends JpaRepository<Compra,Long> {

    List<CompraResponseDto> findAllProjectedBy();


    @Query(value = "SELECT avg(precioCompraP) FROM compra c where c.id_cedear= :idCedear", nativeQuery=true)
    Double findCompraArsAvgById(Long idCedear);

    @Query(value = "SELECT sum(precioCompraP) FROM compra c where c.id_cedear= :idCedear", nativeQuery=true)
    Double findCompraArsSumById(Long idCedear);

    @Query(value = "SELECT sum(cantidadCompra) FROM compra c where c.id_cedear= :idCedear", nativeQuery=true)
    Long findCompraCantidadById(Long idCedear);
}
