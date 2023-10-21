package tec.ispc.workflix.views.ui.dashboard_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import tec.ispc.workflix.R;
import tec.ispc.workflix.views.MainActivity;
import tec.ispc.workflix.views.ui.back.ServicioActivity;

public class DashboardAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_admin);
    }

    public void Usuarios(View view){
        Intent verIntent = new Intent(this, DashboardUsuariosActivity.class);
        startActivity(verIntent);
    }

    public void servicios(View view){
        Intent verServicios = new Intent(this, ServicioActivity.class);
        startActivity(verServicios);
    }
}
