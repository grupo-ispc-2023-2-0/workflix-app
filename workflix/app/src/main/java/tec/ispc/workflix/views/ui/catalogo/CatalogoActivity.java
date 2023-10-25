package tec.ispc.workflix.views.ui.catalogo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Usuario;

public class CatalogoActivity extends AppCompatActivity implements ProfesionalAdapter.OnUsuarioClickListener {

    private RecyclerView recyclerView;
    private ImageView arrowLeft;
    private ImageView arrowRight;
    private Button hireButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        recyclerView = findViewById(R.id.recyclerView);
        arrowLeft = findViewById(R.id.arrowLeft);
        arrowRight = findViewById(R.id.arrowRight);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ProfesionalAdapter adapter = new ProfesionalAdapter(getListaDeProfesionales(), this, this);
        recyclerView.setAdapter(adapter);

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
    }

    private List<Usuario> getListaDeProfesionales() {
        // Aquí deberías realizar una solicitud a tu servidor o base de datos para obtener la lista de profesionales.
        // Por ahora, proporcionaré una lista de ejemplo.
        List<Usuario> profesionales = new ArrayList<>();
        // Llena la lista con datos de profesionales (usuarios) obtenidos de tu servidor.

        return profesionales;
    }

    @Override
    public void onUsuarioClick(int usuarioId) {
        // Maneja el clic en un usuario (profesional).
        // Abre una nueva actividad o fragmento para mostrar detalles del usuario.
        //Intent intent = new Intent(this, DetallesUsuarioActivity.class);
        //intent.putExtra("usuario_id", usuarioId);
        //startActivity(intent);
    }
}
