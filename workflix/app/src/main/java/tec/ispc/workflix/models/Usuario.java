package tec.ispc.workflix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("is_admin")
    @Expose
    private boolean is_admin;
    public Usuario(){};

    public Usuario(int id, String nombre, String apellido, String clave, String telefono, String correo, boolean is_admin) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.telefono = telefono;
        this.correo = correo;
        this.is_admin = is_admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}
