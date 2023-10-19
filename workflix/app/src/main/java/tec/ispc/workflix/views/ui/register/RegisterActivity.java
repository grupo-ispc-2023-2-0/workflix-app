package tec.ispc.workflix.views.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

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
import tec.ispc.workflix.views.ui.perfil.CrearPerfilActivity;
import tec.ispc.workflix.views.ui.perfil_terminos.PerfilTerminosActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText nombreEditText, apellidoEditText, correoEditText, claveEditText, clave2EditText, telefonoEditText;
    Button registrarseButton;
//    UsuarioService usuarioService;

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
                                                 public void onClick(View view) {
                                                     registerUser();
                                                 }

/*                                                     String nombre = nombreEditText.getText().toString();
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

                                                         registerUser();
                                                     }
                                                 }*/
        });
    }
  /*          @Override
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

}*/

    private void registerUser() {
        if (!validateEmail() || !validatePassword()){
            return;
        }
        // Fin check por errores
        RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
        // The Url Posting to

        String url = "http://192.168.0.125:8080/api/v1/user/register";

        // Set paramaters
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("nombre", nombreEditText.getText().toString());
        params.put("apellido", apellidoEditText.getText().toString());
        params.put("correo", correoEditText.getText().toString());
        params.put("clave", claveEditText.getText().toString());
        params.put("telefono", telefonoEditText.getText().toString());

        // Set request object

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params),
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Obtengo valores de respuesta del objeto
                            String first_name = (String) response.get("nombre");
                            String last_name = (String) response.get("apellido");
                            String tel = (String) response.get("telefono");
                            String email = (String) response.get("correo");
                            String password = (String) response.get("clave");

                            // Intent para ir al perfil
                            Intent intent =new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            // Paso valores al perfil de la actividad

                            finish();


                        }catch (JSONException e){
                            e.printStackTrace();
                            System.out.println(e.getMessage());
                        } // Fin de catch
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
                System.out.println(error.getMessage());
                Toast.makeText(RegisterActivity.this,"El registro falló",Toast.LENGTH_LONG).show();
            }
        }
        );// Fin request del objeto

        queue.add(jsonObjectRequest);
    };

    public boolean validateNombre(){
        String nombre = nombreEditText.getText().toString();

        if(nombre.isEmpty()){
            nombreEditText.setError("Debe colocar un nombre");
            return false;
        }else{
            nombreEditText.setError(null);
            return true;
        }
    }// Revisa si nombre está vacio.
    public boolean validateApellido(){
        String apellido = apellidoEditText.getText().toString();

        if(apellido.isEmpty()){
            apellidoEditText.setError("Debe colocar un apellido");
            return false;
        }else{
            apellidoEditText.setError(null);
            return true;
        }
    }// Revisa si apellido está vacio.

    public boolean validateCorreo(){
        String correo = correoEditText.getText().toString();
        // Check If Email Is Empty:
        if(correo.isEmpty()){
            correoEditText.setError("Debe colocar un correo");
            return false;
        }else if(!isValidEmail(correo)){
            correoEditText.setError("Por favor ingrese un correo valido");
            return false;
        }else{
            correoEditText.setError(null);
            return true;
        }// Check If Email Is Empty.
    }
   private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }

    private boolean validatePassword() {
        return true;
    }

    private boolean validateEmail() {
        return true;
    }
    public void irLogin(View view) {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
        finish();

    }
    }