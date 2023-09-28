package tec.ispc.workflix.views.ui.perfil_terminos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import tec.ispc.workflix.R;
import tec.ispc.workflix.views.ui.perfil.CrearPerfilActivity;

public class PerfilTerminosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_terminos);
    }
    public void irPerfilEditar(View view) {
        Intent irPerfilEditarIntent = new Intent(this, CrearPerfilActivity.class);
        startActivity(irPerfilEditarIntent);
    }
}