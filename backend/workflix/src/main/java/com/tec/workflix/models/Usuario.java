package com.tec.workflix.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "Usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String correo;
    @Column
    private String telefono;
    @Column
    private String clave;

}
