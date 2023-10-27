package tec.ispc.workflix.views.ui.catalogo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Usuario;
import tec.ispc.workflix.utils.Apis;
import tec.ispc.workflix.utils.UsuarioService;

public class CatalogoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView arrowLeft;
    private ImageView arrowRight;
    private Button hireButton;
    private ProfesionalAdapter profesionalAdapter;
    private List<Usuario> profesionales = new ArrayList<>(); // Lista para almacenar profesionales

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        recyclerView = findViewById(R.id.recyclerView);
        arrowLeft = findViewById(R.id.arrowLeft);
        arrowRight = findViewById(R.id.arrowRight);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        profesionalAdapter = new ProfesionalAdapter(profesionales, this, new ProfesionalAdapter.OnUsuarioClickListener() {
            @Override
            public void onUsuarioClick(int position) {
                // Maneja el clic en un usuario (profesional).
                abrirDetallesUsuario(profesionales.get(position).getId()); // Abre la actividad de detalles con el ID del usuario
            }
        });

        recyclerView.setAdapter(profesionalAdapter);

        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lógica para desplazarse hacia la izquierda
            }
        });

        arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lógica para desplazarse hacia la derecha
            }
        });


        getListaDeProfesionales();
    }

    private void getListaDeProfesionales() {
        UsuarioService usuarioService = Apis.getUsuarioService();
        Call<List<Usuario>> call = usuarioService.getUsuarios();

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful()) {
                    List<Usuario> usuarios = response.body();
                    profesionales.addAll(usuarios);
                    profesionalAdapter.notifyDataSetChanged(); // Avisa al adaptador que los datos han cambiado.
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.e("Error al obtener lista de profesionales", t.getMessage());
            }
        });
    }

    private void abrirDetallesUsuario(int usuarioId) {
        // Crea un Intent para abrir la actividad de detalles del usuario (TarjetaAmpliadaActivity).
        Intent intent = new Intent(CatalogoActivity.this, TarjetaAmpliadaActivity.class);

        // Pasa el ID del usuario a la actividad de detalles.
        intent.putExtra("usuario_id", usuarioId);

        // Inicia la actividad de detalles.
        startActivity(intent);
    }
}