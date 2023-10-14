package com.tec.workflix.interfaces;

import com.tec.workflix.models.Usuario;

public interface IAutenticacionUsuario {
    public Usuario obtenerUsuario(Usuario usuario);
    public Usuario registrarUsuario(Usuario usuario);
}
