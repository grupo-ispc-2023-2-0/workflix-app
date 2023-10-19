package com.tec.workflix.models;


import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class Profesional extends Usuario{
    private String telefono;
    private String direccion;
    private String correo;
    private String ciudad;
    private String provincia;
    private String descripcion;
    private String foto;
    private String profesion;
}
