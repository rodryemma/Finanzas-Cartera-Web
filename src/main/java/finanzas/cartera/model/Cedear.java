package finanzas.cartera.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="cedear")
@SQLDelete(sql = "UPDATE cedear SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class Cedear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "cedear.error.blank.nombre")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "cedear.error.blank.simbolo")
    @Column(nullable = false)
    private String simbolo;

    private Long cantidad;

    private boolean deleted = Boolean.FALSE;



}
