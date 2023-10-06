package tec.ispc.workflix.views.ui.dashboard_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tec.ispc.workflix.R;
import tec.ispc.workflix.utils.UsuarioService;

public class ListarUsuariosActivity extends AppCompatActivity {
    UsuarioService usuarioService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);
    }
}