package tec.ispc.workflix.views.ui.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tec.ispc.workflix.R;
import tec.ispc.workflix.views.MainActivity;
import tec.ispc.workflix.views.ui.eliminar_cuenta.EliminarCuentaActivity;
import tec.ispc.workflix.views.ui.perfil_terminos.PerfilTerminosActivity;

public class CrearPerfilActivity extends AppCompatActivity {

    TextView first_name, last_name, email;
    Button sign_out_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_perfil);
    }
    public void cerrarSesion (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void cerrarCuenta (View view) {
        Intent intent = new Intent(this, EliminarCuentaActivity.class);
        startActivity(intent);
    }


}

