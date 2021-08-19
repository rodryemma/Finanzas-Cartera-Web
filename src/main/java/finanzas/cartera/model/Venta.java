package finanzas.cartera.model;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="venta")
@SQLDelete(sql = "UPDATE venta SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long nroVenta;

    @NotNull(message = "{venta.error.null.precioVentaP}")
    @Column(nullable = false)
    private Double precioVentaP;

    @NotNull(message = "{venta.error.null.precioVentaD}")
    @Column(nullable = false)
    private Double precioVentaD;

    @NotNull(message = "{venta.error.null.cantidadVenta}")
    @Column(nullable = false)
    private Long cantidadVenta;

    private Double difVentaCompraP;

    private Double difVentaCompraD;

    @Column(name = "created_date", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "edited_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date edited;

    private boolean deleted = Boolean.FALSE;

}
