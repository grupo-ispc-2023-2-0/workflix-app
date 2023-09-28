package tec.ispc.workflix.views.ui.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import tec.ispc.workflix.R;
import tec.ispc.workflix.views.ui.eliminar_cuenta.EliminarCuentaActivity;

public class CrearPerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_perfil);
    }
    public void cerrarCuenta (View view) {
        Intent intent = new Intent(this, EliminarCuentaActivity.class);
        startActivity(intent);
    }
}
