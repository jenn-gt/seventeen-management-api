package com.jenn_gt.seventeen_management_api.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity                     // Le dice a Hibernate: "Esto es una tabla".
@Table(name = "MIEMBRO")    // Nombre exacto de la tabla en SQL.
@Data                       // Genera Getters, Setters, toString, etc. Hace más limpio el código (Lombok)
public class Miembro {
    
    @Id                                                 // Indica que es la Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera un valor autoincrementable
    @Column(name = "id_miembro")                        // Propiedades de la columna (name, nullable, lenght, unique)
    private Long id;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(name = "stage_name", nullable = false, unique = true, length = 50)
    private String stageName;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;


    // RELACIONES (FK)
    // Por ahora las pondremos como IDs simples para no complicarnos,
    // pero luego las podemos transformar en Objetos completos.
    
    @Column(name = "id_subunidad")
    private Integer idSubunidad;

    @Column(name = "id_pais", nullable = false)
    private Integer idPais;
}
