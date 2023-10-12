package tec.ispc.workflix.utils;

import retrofit2.Call;
import tec.ispc.workflix.models.Usuario;

public class Apis {
    //public static final String URL_001="http://192.168.0.125:8080/personas/";
    public static final String URL_002="http://192.168.0.125:8080/usuarios/";


    public static UsuarioService getUsuarioService(){
        return Cliente.getCliente(URL_002).create(UsuarioService.class);
    }

}
