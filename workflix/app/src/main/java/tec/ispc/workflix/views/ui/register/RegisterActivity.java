package tec.ispc.workflix.views.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import tec.ispc.workflix.R;
import tec.ispc.workflix.views.ui.login.LoginActivity;
import tec.ispc.workflix.views.ui.perfil_terminos.PerfilTerminosActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void irLogin(View view) {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);

    }
    public void irPerfil(View view) {
        Intent irPerfilIntent = new Intent(this, PerfilTerminosActivity.class);
        startActivity(irPerfilIntent);
    }
}