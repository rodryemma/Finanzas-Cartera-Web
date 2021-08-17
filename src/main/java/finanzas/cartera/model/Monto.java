package finanzas.cartera.model;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name="monto")
@SQLDelete(sql = "UPDATE monto SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Monto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montoIngresado;

    private Double montoRetirado;

    private Double montoActual;

    private boolean deleted = Boolean.FALSE;
}
