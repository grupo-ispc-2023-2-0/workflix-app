package com.tec.workflix.modelsDAO;

import com.tec.workflix.interfaces.IUsuarioInterface;
import com.tec.workflix.models.Usuario;

import java.util.List;
import java.util.Map;

public class ProfesionalDAO implements IUsuarioInterface {
    @Override
    public List<Map<String, Object>> listar() {
        return null;
    }

    @Override
    public List<Map<String, Object>> listarId(int id) {
        return null;
    }

    @Override
    public int add(Usuario usuario) {
        return 0;
    }

    @Override
    public int edit(Usuario usuario) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
