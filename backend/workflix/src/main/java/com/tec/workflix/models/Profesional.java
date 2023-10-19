package com.tec.workflix.models;


import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class Profesional extends Usuario{
    private String telefono, direccion, correo, ciudad, provincia, descripcion, foto, valoracion, profesion;

}
