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
import tec.ispc.workflix.utils.UsuarioService;
import tec.ispc.workflix.views.MainActivity;
import tec.ispc.workflix.views.ui.dashboard_admin.DashboardUsuariosActivity;

public class Perfil extends AppCompatActivity {
 private UsuarioService usuarioService;
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

        public void eliminarCuentaPerfil(View view){
            deleteUsuario(Integer.valueOf(id));
            Intent intent =new Intent(Perfil.this, DashboardUsuariosActivity.class);
            startActivity(intent);
        }

    }
}

