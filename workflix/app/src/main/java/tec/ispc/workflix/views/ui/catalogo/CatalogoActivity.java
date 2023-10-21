package tec.ispc.workflix.views.ui.catalogo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Profesional;

public class CatalogoActivity extends AppCompatActivity implements ProfesionalAdapter.OnProfesionalClickListener {

    private HorizontalScrollView horizontalScrollView;
    private ImageView arrowLeft;
    private ImageView arrowRight;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        horizontalScrollView = findViewById(R.id.horizontalScrollView);
        arrowLeft = findViewById(R.id.arrowLeft);
        arrowRight = findViewById(R.id.arrowRight);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ProfesionalAdapter adapter = new ProfesionalAdapter(getListaDeProfesionales(), this, this);
        recyclerView.setAdapter(adapter);

        horizontalScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (horizontalScrollView.canScrollHorizontally(1)) {
                    arrowRight.setVisibility(View.VISIBLE);
                } else {
                    arrowRight.setVisibility(View.INVISIBLE);
                }

                if (horizontalScrollView.getScrollX() > 0) {
                    arrowLeft.setVisibility(View.VISIBLE);
                } else {
                    arrowLeft.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private List<Profesional> getListaDeProfesionales() {
        List<Profesional> profesionales = new ArrayList<>();

        profesionales.add(new Profesional("Juan", "Pérez", R.drawable.profesional_1, 4.5f, "Plomería general, industrial, arreglos menores y planificación de obras", "Plomero"));
        profesionales.add(new Profesional("Cristian", "Castro", R.drawable.profesional_2, 4.0f, "Instalaciones eléctricas, reparaciones y más.", "Electricista"));
        profesionales.add(new Profesional("Cosme", "Fulanito", R.drawable.profesional_3, 4.8f, "Pintura interior y exterior, pintura artística.", "Pintor"));
        profesionales.add(new Profesional("Ricardo", "Tapia", R.drawable.profesional_4, 4.2f, "Construcción de estructuras, reparaciones de albañilería.", "Albañil"));
        profesionales.add(new Profesional("Homero", "Thompson", R.drawable.profesional_5, 4.7f, "Carpintería, muebles a medida, reparaciones de madera.", "Carpintero"));

        return profesionales;
    }

    @Override
    public void onProfesionalClick(int profesionalId) {

        Intent intent = new Intent(this, TarjetaAmpliadaActivity.class);
        intent.putExtra("profesional_posicion", profesionalId);
        startActivity(intent);
    }
}
