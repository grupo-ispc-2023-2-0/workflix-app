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
    private EditText nombreEditText, apellidoEditText, correoEditText, claveEditText, clave2EditText, telefonoEditText;
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
        clave2EditText= findViewById(R.id.editTextTextPassword2);
        telefonoEditText = findViewById(R.id.editTextPhone);


        registrarseButton = findViewById(R.id.button);
        registrarseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreEditText.getText().toString();
                String apellido = apellidoEditText.getText().toString();
                String correo = correoEditText.getText().toString();
                String clave = claveEditText.getText().toString();
                String clave2= clave2EditText.getText().toString();
                String telefono = telefonoEditText.getText().toString();

                if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || clave.isEmpty() || clave2.isEmpty() || telefono.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show();
                } else if (!isValidEmail(correo)) {
                    Toast.makeText(RegisterActivity.this, "Correo electrónico no válido", Toast.LENGTH_LONG).show();
                } else if (clave.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_LONG).show();
                } else if (!clave.equals(clave2)) {
                    Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                } else {

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
            }
        });
    }
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }
    public void addUsuario(Usuario usuario){
        usuarioService = Apis.getUsuarioService();
        Call<Usuario> call=usuarioService.addUsuario(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"Usuario agregado con éxito",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("Error al agregar Usuario:",t.getMessage());
            }
        });
        Intent intent =new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void irLogin(View view) {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);

    }

}