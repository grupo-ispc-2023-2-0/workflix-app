package tec.ispc.workflix.utils;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import tec.ispc.workflix.models.Persona;

public interface PersonaService {
    @GET
    Call<List<Persona>> getPersonas();
}
