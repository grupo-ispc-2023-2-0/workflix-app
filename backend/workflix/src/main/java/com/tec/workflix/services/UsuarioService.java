package com.tec.workflix.services;

import com.tec.workflix.interfaces.IUsuarioInterface;
import com.tec.workflix.models.Usuario;
import com.tec.workflix.modelsDAO.UsuarioDAO;

import java.util.List;
import java.util.Map;

public class UsuarioService implements IUsuarioInterface {

    UsuarioDAO dao;

    @Override
    public List<Map<String, Object>> listar() {
       return dao.listar();
    }

    @Override
    public List<Map<String, Object>> listarId(int id) {
        return null;
    }

    @Override
    public int add(Usuario usuario) {
        return dao.add(usuario);
    }

    @Override
    public int edit(Usuario usuario) {
        return dao.edit(usuario);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }
}
