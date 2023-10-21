package tec.ispc.workflix.views.ui.perfil_terminos;

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
import tec.ispc.workflix.views.ui.perfil.Perfil;

public class PerfilTerminosActivity extends AppCompatActivity {
    private TextView tv_nombre, tv_apellido, tv_telefono;
    private Button sign_out_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_terminos);

        tv_nombre = findViewById(R.id.nombreProf);
        tv_apellido = findViewById(R.id.apellidoProf);
        tv_telefono = findViewById(R.id.descripcion);

        SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String nombre = preferences.getString("nombre", ""); // El segundo parámetro es un valor por defecto si la clave no se encuentra
        String apellido = preferences.getString("apellido", "");
        String telefono = preferences.getString("telefono", "");


        tv_nombre.setText(nombre);
        tv_apellido.setText(apellido);
        tv_telefono.setText(telefono);

        sign_out_btn = findViewById(R.id.btn_Cerrar_sesion);

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

        // Obtener una referencia a SharedPreferences
        SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nombre", null);
        editor.putString("apellido", null);
        editor.putString("correo", null);
        editor.putString("telefono", null);
        editor.apply();
        // Vuelvo al home
        Intent irAlHome = new Intent(PerfilTerminosActivity.this, MainActivity.class);
        startActivity(irAlHome);
        finish();
    }
    public void irPerfilEditar(View view) {
        Intent irPerfilEditarIntent = new Intent(this, Perfil.class);
        startActivity(irPerfilEditarIntent);
        finish();
    }

    public void cerrarSesion (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void terminos (View view) {
        Intent intent = new Intent(this, terminosCondiciones.class);
        startActivity(intent);
        finish();
    }

}