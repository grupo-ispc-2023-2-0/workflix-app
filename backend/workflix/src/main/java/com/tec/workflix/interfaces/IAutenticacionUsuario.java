package com.tec.workflix.interfaces;

import com.tec.workflix.models.Usuario;

public interface IAutenticacionUsuario {
    public boolean autenticarUsuario(String correo, String clave);
    public Usuario registrarUsuario(Usuario usuario);
}
