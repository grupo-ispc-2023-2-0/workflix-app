package tec.ispc.workflix.utils;

public class Apis {
    public static final String URL_001="http://127.0.0.1:8080/personas/";

    public static PersonaService getPersonaService(){
        return Cliente.getCliente(URL_001).create(PersonaService.class);
    }
}
