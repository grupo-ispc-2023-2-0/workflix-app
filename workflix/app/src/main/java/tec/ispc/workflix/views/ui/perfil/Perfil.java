package tec.ispc.workflix.views.ui.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tec.ispc.workflix.R;
import tec.ispc.workflix.views.MainActivity;

public class Perfil extends AppCompatActivity {

    private TextView tv_nombre, tv_apellido, tv_correo, tv_telefono;
    private Button sign_out_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_perfil);

        // Text views objetos
        tv_nombre = findViewById(R.id.perfilNombre);
        tv_apellido = findViewById(R.id.perfilApellido);
        tv_correo = findViewById(R.id.perfilCorreo);
        tv_telefono = findViewById(R.id.perfilTelefono);

        SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String nombre = preferences.getString("nombre", ""); // El segundo parámetro es un valor por defecto si la clave no se encuentra
        String apellido = preferences.getString("apellido", "");
        String correo = preferences.getString("correo", "");
        String telefono = preferences.getString("telefono", "");

        // Seteo los valores al perfil

        tv_nombre.setText(nombre);
        tv_apellido.setText(apellido);
        tv_telefono.setText(correo);
        tv_correo.setText(telefono);

        // Boton salir
        sign_out_btn = findViewById(R.id.sign_out_btn);

        // Set On click listener
        sign_out_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarSesion();
            }
        });
    }
    public void cerrarSesion () {
        // Vuelvo los valores a null
        tv_nombre.setText(null);
        tv_apellido.setText(null);
        tv_telefono.setText(null);
        tv_correo.setText(null);
        // Vuelvo al home
       Intent irAlHome = new Intent(Perfil.this, MainActivity.class);
       startActivity(irAlHome);
       finish();
    }
 /*   public void cerrarCuenta (View view) {
        Intent intent = new Intent(this, EliminarCuentaActivity.class);
        startActivity(intent);
    }*/


}

