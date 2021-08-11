package finanzas.cartera.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="cedear")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class Cedear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String simbolo;

    private Long cantidad;



}
