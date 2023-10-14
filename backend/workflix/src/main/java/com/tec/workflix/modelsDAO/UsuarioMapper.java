package com.tec.workflix.modelsDAO;

import com.tec.workflix.models.Usuario;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario> {
    @Override
    public Usuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getInt("id"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setApellido(resultSet.getString("apellido"));
        usuario.setClave(resultSet.getString("clave"));
        usuario.setTelefono(resultSet.getString("telefono"));
        usuario.setCorreo(resultSet.getString("correo"));
        return usuario;
    }
}