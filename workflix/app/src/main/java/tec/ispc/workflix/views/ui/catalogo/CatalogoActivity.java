package tec.ispc.workflix.views.ui.catalogo;

import static tec.ispc.workflix.R.layout.activity_catalogo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Usuario;
import tec.ispc.workflix.utils.Apis;
import tec.ispc.workflix.utils.UsuarioService;
import tec.ispc.workflix.views.ui.back.UsuarioAdapter;

public class CatalogoActivity extends AppCompatActivity {
    private ListView listViewUsuarios;
    private UsuarioAdapter usuarioAdapter;
    private List<Usuario> listaDeUsuarios = new ArrayList<>(); // Inicializa la lista

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_catalogo);

        listViewUsuarios = findViewById(R.id.listViewUsuarios);
        usuarioAdapter = new UsuarioAdapter(this, activity_catalogo, listaDeUsuarios);
        listViewUsuarios.setAdapter(usuarioAdapter);

        listViewUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario usuarioSeleccionado = listaDeUsuarios.get(position);
            }
        });

        obtenerListaDeUsuarios();
    }

    private void obtenerListaDeUsuarios() {
        UsuarioService usuarioService = Apis.getUsuarioService();
        Call<List<Usuario>> call = usuarioService.getUsuarios();

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful()) {
                    listaDeUsuarios = response.body();
                    // Filtrar la lista para mostrar solo usuarios que no son administradores
                    listaDeUsuarios = filtrarUsuariosNoAdmin(listaDeUsuarios);
                    usuarioAdapter.clear();
                    usuarioAdapter.addAll(listaDeUsuarios);
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.e("Error al obtener lista de usuarios", t.getMessage());
            }
        });
    }

    private List<Usuario> filtrarUsuariosNoAdmin(List<Usuario> usuarios) {
        List<Usuario> usuariosNoAdmin = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (!usuario.isIs_admin()) {
                usuariosNoAdmin.add(usuario);
            }
        }
        return usuariosNoAdmin;
    }
}