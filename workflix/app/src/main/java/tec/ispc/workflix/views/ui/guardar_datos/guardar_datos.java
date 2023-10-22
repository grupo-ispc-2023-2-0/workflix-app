package tec.ispc.workflix.views.ui.guardar_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import tec.ispc.workflix.R;
import tec.ispc.workflix.views.MainActivity;
import tec.ispc.workflix.views.ui.perfil.Perfil;

public class guardar_datos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_datos);
    }

    public void btEnviar2 (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}