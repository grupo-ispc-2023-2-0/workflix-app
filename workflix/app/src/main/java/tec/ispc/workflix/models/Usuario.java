package tec.ispc.workflix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Usuario {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("apellido")
    @Expose
    private String apellido;

    @SerializedName("clave")
    @Expose
    private String clave;

    @SerializedName("telefono")
    @Expose
    private String telefono;

    @SerializedName("correo")
    @Expose
    private String correo;


}
