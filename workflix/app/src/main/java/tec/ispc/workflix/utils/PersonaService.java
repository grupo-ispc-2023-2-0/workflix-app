package tec.ispc.workflix.utils;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import tec.ispc.workflix.models.Persona;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PersonaService {

    @GET("listar")
    Call<List<Persona>> getPersonas();

    @POST("agregar")
    Call<Persona>addPersona(@Body Persona persona);

    @POST("actualizar/{id}")
    Call<Persona>updatePersona(@Body Persona persona,@Path("id") int id);

    @POST("eliminar/{id}")
    Call<Persona>deletePersona(@Path("id")int id);

}
