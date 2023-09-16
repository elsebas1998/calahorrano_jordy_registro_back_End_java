package com.jsca.jsca.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tbl_cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 15)
    @NotEmpty
    private String name;

    @Size(min = 5, max = 50)
    @Email(message = "El formato del correo electrónico no es válido")
    @Column(name= "email", unique = true, nullable = false)
    private String email;

    @Pattern(regexp = "^09\\d{8}$", message = "Número de teléfono no válido")
    private String telefono;

    @Size(min = 2, max = 2)
    @NotEmpty
    private String grupo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Beneficio> beneficios;
}
