package com.tec.workflix.models;

import com.tec.workflix.interfaces.IUsuarioInterface;

import java.util.List;
import java.util.Map;

public class Profesionales extends Usuario  {

    private String telefono, direccion, correo, ciudad, provincia, descripcion, foto, valoracion, profesion;



    public Profesionales(String telefono, String direccion, String correo, String ciudad, String provincia, String descripcion, String foto, String valoracion, String profesion) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.descripcion = descripcion;
        this.foto = foto;
        this.valoracion = valoracion;
        this.profesion = profesion;
    }

    public Profesionales(int id, String nombre, String apellido, String correo, String telefono, String clave, String telefono1, String direccion, String correo1, String ciudad, String provincia, String descripcion, String foto, String valoracion, String profesion) {
        super(id, nombre, apellido, correo, telefono, clave);
        this.telefono = telefono1;
        this.direccion = direccion;
        this.correo = correo1;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.descripcion = descripcion;
        this.foto = foto;
        this.valoracion = valoracion;
        this.profesion = profesion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}
