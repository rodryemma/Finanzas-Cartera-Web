package finanzas.cartera.model;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="compra")
@SQLDelete(sql = "UPDATE compra SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long nroCompra;

    @NotNull(message = "{compra.error.null.preciocomprap}")
    @Column(nullable = false)
    private Double precioCompraP;

    @NotNull(message = "{compra.error.null.preciocomprad}")
    @Column(nullable = false)
    private Double precioCompraD;

    @NotNull(message = "{compra.error.null.cantidadcompra}")
    @Column(nullable = false)
    private Long cantidadCompra;

    @Column(name = "created_date", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "edited_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date edited;

    private boolean deleted = Boolean.FALSE;

}
