package tec.ispc.workflix.views.ui.catalogo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;
import tec.ispc.workflix.R;

public class TarjetaAmpliadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta_ampliada);

        // Obtén los datos pasados desde CatalogoAdapter
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nombreCompleto = extras.getString("nombreCompleto");
            String apellido = extras.getString("apellido");
            String imagenURL = extras.getString("imagenURL");
            String servicio = extras.getString("servicio");
            String descripcion = extras.getString("descripcion");
            String correo = extras.getString("correo");
            String telefono = extras.getString("telefono");
            String ciudad = extras.getString("ciudad");
            String provincia = extras.getString("provincia");

            // Ahora puedes mostrar estos datos en tus TextViews
            TextView perfilNombreTextView = findViewById(R.id.perfilNombre);
            TextView perfilApellidoTextView = findViewById(R.id.perfilApellido);
            ImageView imagenFotoImageView = findViewById(R.id.imagenFoto);
            TextView perfilServicioTextView = findViewById(R.id.perfilServicio);
            TextView perfilDescripcionTextView = findViewById(R.id.perfilDescripcion);
            TextView perfilCorreoTextView = findViewById(R.id.perfilCorreo);
            TextView perfilTelefonoTextView = findViewById(R.id.perfilTelefono);
            TextView perfilCiudadTextView = findViewById(R.id.perfilCiudad);
            TextView perfilProvinciaTextView = findViewById(R.id.perfilProvincia);


            if (nombreCompleto != null) {
                perfilNombreTextView.setText(nombreCompleto);
            }
            if (apellido != null) {
                perfilApellidoTextView.setText(apellido);
            }

            if (imagenURL != null) {

                Picasso.get().load(imagenURL).into(imagenFotoImageView);
            }

            if (servicio != null) {
                perfilServicioTextView.setText(servicio);
            }
            if (descripcion != null) {
                perfilDescripcionTextView.setText(descripcion);
            }
            if (correo != null) {
                perfilCorreoTextView.setText(correo);
            }
            if (telefono != null) {
                perfilTelefonoTextView.setText(telefono);
            }
            if (ciudad != null) {
                perfilCiudadTextView.setText(ciudad);
            }
            if (provincia != null) {
                perfilProvinciaTextView.setText(provincia);
            }
        }
    }
}