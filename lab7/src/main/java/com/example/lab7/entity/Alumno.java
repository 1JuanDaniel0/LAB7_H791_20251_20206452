package com.example.lab7.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "alumno")
@Getter
@Setter
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "dni", nullable = false)
    private Integer dni;

    @Column(name = "codigo", nullable = false)
    private Integer codigo;

    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "sexo", nullable = false)
    private Byte sexo;

    @Column(name = "correoInstitucional", nullable = false)
    private String correoInstitucional;

    @Column(name = "correoPersonal")
    private String correoPersonal;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "carrera")
    private String carrera;

    @Column(name = "fechaRegistro", nullable = false)
    private Timestamp fechaRegistro;

    @Column(name = "ultimaActualizacion", nullable = false)
    private Timestamp ultimaActualizacion;

    @Column(name = "estado", nullable = false)
    private Boolean estado = true;

}
