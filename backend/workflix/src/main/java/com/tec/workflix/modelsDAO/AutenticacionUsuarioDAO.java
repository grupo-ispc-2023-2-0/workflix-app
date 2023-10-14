package com.tec.workflix.modelsDAO;

import com.tec.workflix.interfaces.IAutenticacionUsuario;
import com.tec.workflix.models.Usuario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutenticacionUsuarioDAO implements IAutenticacionUsuario {

    JdbcTemplate template;
    @Override
    public boolean autenticarUsuario(String correo, String clave) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE correo = ? AND clave = ?";
        int count = template.queryForObject(sql, new Object[]{correo, clave}, Integer.class);
        return count == 1;
    }



    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario(nombre, apellido, clave, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, usuario.getNombre(), usuario.getApellido(), usuario.getClave(), usuario.getTelefono(), usuario.getCorreo());
        return usuario;
    }
}
