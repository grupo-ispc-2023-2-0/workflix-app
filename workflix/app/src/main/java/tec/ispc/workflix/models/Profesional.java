package tec.ispc.workflix.models;

public class Profesional {
    private String nombre;
    private String apellido;
    private int imagenPerfil;
    private float valoracion;
    private String descripcion;
    private String profesion;

    public Profesional(String nombre, String apellido, int imagenPerfil, float valoracion, String descripcion, String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagenPerfil = imagenPerfil;
        this.valoracion = valoracion;
        this.descripcion = descripcion;
        this.profesion = profesion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getImagenPerfil() {
        return imagenPerfil;
    }

    public float getValoracion() {
        return valoracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getProfession() {
        return profesion;
    }

    public boolean getId() {
        return false;
    }
}
