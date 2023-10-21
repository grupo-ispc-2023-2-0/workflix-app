package tec.ispc.workflix.views.ui.catalogo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import tec.ispc.workflix.R;

public class TarjetaAmpliadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta_ampliada);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int profesionalPosicion = extras.getInt("profesional_posicion", -1);

            if (profesionalPosicion != -1) {

                TextView textView = findViewById(R.id.textView);
                textView.setText("Mostrando detalles del profesional en la posición: " + profesionalPosicion);
            }
        }
    }
}
