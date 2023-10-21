package com.tec.workflix.modelsDAO;

import com.tec.workflix.interfaces.IServicioInterface;
import com.tec.workflix.models.Servicio;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ServicioDAO implements IServicioInterface {


    @Override
    public List<Map<String, Object>> listar() {
        return null;
    }

    @Override
    public List<Map<String, Object>> listarId(int id) {
        return null;
    }

    @Override
    public int add(Servicio servicio) {
        return 0;
    }

    @Override
    public int edit(Servicio servicio) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
