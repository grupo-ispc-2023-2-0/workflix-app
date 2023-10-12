package tec.ispc.workflix.views.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tec.ispc.workflix.R;
import tec.ispc.workflix.models.Usuario;
import tec.ispc.workflix.utils.Apis;
import tec.ispc.workflix.utils.UsuarioService;
import tec.ispc.workflix.views.ui.back.UsuarioActivity;
import tec.ispc.workflix.views.ui.dashboard_admin.DashboardActivity;
import tec.ispc.workflix.views.ui.login.LoginActivity;
import tec.ispc.workflix.views.ui.perfil_terminos.PerfilTerminosActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText nombreEditText, apellidoEditText, correoEditText, claveEditText, telefonoEditText;
    private Button registrarseButton;
    UsuarioService usuarioService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombreEditText = findViewById(R.id.editTextText);
        apellidoEditText = findViewById(R.id.editTextText2);
        correoEditText = findViewById(R.id.editTextTextEmailAddress);
        claveEditText = findViewById(R.id.editTextTextPassword);
        telefonoEditText = findViewById(R.id.editTextPhone);


        registrarseButton = findViewById(R.id.button);
        registrarseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();

                usuario.setNombre(nombreEditText.getText().toString());
                usuario.setApellido(apellidoEditText.getText().toString());
                usuario.setClave(claveEditText.getText().toString());
                usuario.setTelefono(telefonoEditText.getText().toString());
                usuario.setCorreo(correoEditText.getText().toString());



                    addUsuario(usuario);
                    Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(loginIntent);

                }
        });

    }
    public void addUsuario(Usuario usuario){
        usuarioService = Apis.getUsuarioService();
        Call<Usuario> call=usuarioService.addUsuario(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"Se agrego un Usuario con éxito",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("Error al agregar un Usuario:",t.getMessage());
            }
        });
        Intent intent =new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
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