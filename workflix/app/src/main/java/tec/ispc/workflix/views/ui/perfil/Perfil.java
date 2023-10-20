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

    TextView tv_first_name, tv_last_name, tv_email, tv_tel;
    Button sign_out_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_perfil);

        // Text views objetos
        tv_first_name = findViewById(R.id.first_name);
        tv_last_name = findViewById(R.id.last_name);
        tv_email = findViewById(R.id.email);
        tv_tel = findViewById(R.id.tel);

        SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String first_name = preferences.getString("first_name", ""); // El segundo parámetro es un valor por defecto si la clave no se encuentra
        String last_name = preferences.getString("last_name", "");
        String email = preferences.getString("email", "");
        String tel = preferences.getString("tel", "");

        // Seteo los valores al perfil

        tv_first_name.setText(first_name);
        tv_last_name.setText(last_name);
        tv_email.setText(email);
        tv_tel.setText(tel);

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
        tv_first_name.setText(null);
        tv_last_name.setText(null);
        tv_tel.setText(null);
        tv_email.setText(null);
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

