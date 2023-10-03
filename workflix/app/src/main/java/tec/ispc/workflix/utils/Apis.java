package tec.ispc.workflix.utils;

public class Apis {
    public static final String URL_001="http://192.168.1.175:8080/";

    public static PersonaService getPersonaService(){
        return Cliente.getCliente(URL_001).create(PersonaService.class);
    }
}
