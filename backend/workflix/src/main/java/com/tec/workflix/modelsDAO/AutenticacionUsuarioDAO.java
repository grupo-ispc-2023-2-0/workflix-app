package com.tec.workflix.modelsDAO;

import com.tec.workflix.interfaces.IAutenticacionUsuario;
import com.tec.workflix.models.Usuario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AutenticacionUsuarioDAO implements IAutenticacionUsuario {

    JdbcTemplate template;
    @Override
    public Usuario obtenerUsuario(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE clave = ? AND correo = ?";
        try {
            return template.queryForObject(sql, new Object[]{usuario.getClave(), usuario.getCorreo()}, new UsuarioMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario(nombre, apellido, clave, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, usuario.getNombre(), usuario.getApellido(), usuario.getClave(), usuario.getTelefono(), usuario.getCorreo());
        return usuario;
    }
}
