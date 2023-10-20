package com.tec.workflix.models;


import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Data

public class Profesional extends Usuario{
    @Column
    private String telefono;
    @Column
    private String direccion;
    @Column
    private String correo;
    @Column
    private String ciudad;
    @Column
    private String provincia;
    @Column
    private String descripcion;
    @Column
    private String foto;
    @Column
    private String profesion;
}
